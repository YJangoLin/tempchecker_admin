package com.lzl.tempchecker_admin.module.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzl.tempchecker_admin.enums.LoginStatusEnum;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.dao.UserDao;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zonglin Liang on 2020/12/27.
 * Describe:
 **/
@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserLogService userLogService;

    @Autowired
    UserDao userDao;



    Map<String, Object> session = new HashMap<>();



    @GetMapping("/page")
    @ResponseBody
    public List<User> page(){
        List<User> users = userDao.selectList(null);
        return users;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user1) {
//        params.forEach((k, v)->System.out.println(k+":"+v));
        System.out.println(user1.getAccount());
        Map<String, Object> params = new HashMap<>();
        params.put("account",user1.getAccount());
        params.put("password",user1.getPassword());
        String result = "";
        List<User> users = userDao.selectByMap(params);
        if (users.size()>0){
            User user = users.get(0);
            user.setStatus(1);
            session.put("id", user.getId());
            userLogService.save(new UserLogEntity(user.getAccount(),1));
            userDao.updateById(user);
            result = "登录成功";
        }else {
            userLogService.save(new UserLogEntity(user1.getAccount(),0));
            result = "密码账号不正确";
        }
        return result;
    }

    @GetMapping("/info")
    @ResponseBody
    public UserInfo info(){
        if (session.get("id")!=null){
            return userInfoService.findById((Long) session.get("id"));
        }else {
            return null;
        }

    }


}
