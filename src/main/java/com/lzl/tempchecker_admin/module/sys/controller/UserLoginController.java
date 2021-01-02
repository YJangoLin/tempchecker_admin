package com.lzl.tempchecker_admin.module.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzl.tempchecker_admin.enums.LoginStatusEnum;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.dao.UserDao;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    UserService userService;



    Map<String, Object> session = new HashMap<>();



    @PostMapping("/page")
    @ResponseBody
    public IPage<Map<String, Object>> page(@RequestBody Map<String,Object> params){
        Integer pageNum = (Integer) params.get("pageNum");
        System.out.println(params.get("pageNum"));
        params = (Map<String, Object>) params.get("params");
        Map<String, Object> query = new HashMap<>();
        if (params.get("account")!=null&&params.get("account")!=""){
            query.put("account",params.get("account"));
            System.out.println(params.get("account"));
        }
        if (params.get("createDate")!=null&&params.get("createDate")!=""){
            query.put("create_date",params.get("createDate"));
        }
        if (params.get("status")!=null&&params.get("status")!=""){
                query.put("status",params.get("status"));
        }
        return userService.page(query,pageNum);
    }
    @PostMapping("/leave")
    @ResponseBody
    public String leave(){
        User user = (User) session.get("user");
        user.setStatus(0);
        userService.updateById(user);
        return "退出成功,欢迎下次再来";
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
        List<User> users = userService.selectByMap(params);
        if (users.size()>0){
            User user = users.get(0);
            user.setStatus(1);
            session.put("user", user);
            userLogService.save(new UserLogEntity(user.getAccount(),1,"登录"));
            userService.updateById(user);
            result = "登录成功";
        }else {
            userLogService.save(new UserLogEntity(user1.getAccount(),0,"登录"));
            result = "密码账号不正确";
        }
        return result;
    }

    @GetMapping("/info")
    @ResponseBody
    public UserInfo info(){
//        System.out.println("进入info");
//        System.out.println(session.get("user"));
        if (session.get("user")!=null){
            User user = (User) session.get("user");
            return userInfoService.findById(user.getId());
        }else {
            return null;
        }

    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody User user){
        try {
            if (session.get("user")!=null){
                User user1 = (User) session.get("user");
                userLogService.save(new UserLogEntity(user1.getAccount(),1,"添加用户"));
            }
            return userService.save(user);
        }catch (Exception e){
            if (session.get("user")!=null){
                User user1 = (User) session.get("user");
                userLogService.save(new UserLogEntity(user.getAccount(),0,"添加用户"));
            }
            return "操作失败";
        }

    }
    @GetMapping("/getAuthor")
    @ResponseBody
    public String  getAuthor(){
        User user = (User) session.get("user");
        return user.getAdmin()==1? "admin":"user";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleted(@PathVariable("id")Long id){
        try {
            if (session.get("user")!=null){
                User user = (User) session.get("user");
                userLogService.save(new UserLogEntity(user.getAccount(),1,"删除用户"));
            }
            return userService.deleteById(id);
        }catch (Exception e){
            if (session.get("user")!=null){
                User user = (User) session.get("user");
                userLogService.save(new UserLogEntity(user.getAccount(),0,"删除用户"));
            }
            return "操作失败";
        }


    }

    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody User user){
        try{
            new UserLogEntity(user.getAccount(),1,"更新用户");
            return userService.updateById(user);
        }catch (Exception e){
            new UserLogEntity(user.getAccount(),0,"更新用户");
            return "操作失败";
        }

    }


}
