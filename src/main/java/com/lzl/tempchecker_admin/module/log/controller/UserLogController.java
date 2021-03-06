package com.lzl.tempchecker_admin.module.log.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
@Controller
@RequestMapping("/log")
public class UserLogController {
    @Autowired
    UserLogService userLogService;

    @GetMapping("/findAll")
    @ResponseBody
    public List<UserLogEntity> findAll(){
        return userLogService.findAll();
    }

    @PostMapping("/page")
    @ResponseBody
    public IPage<Map<String, Object>> page(@RequestBody Map<String,Object> params){
        Integer pageNum = (Integer) params.get("pageNum");
        System.out.println(params.get("pageNum"));
        params = (Map<String, Object>) params.get("params");
        Map<String, Object> query = new HashMap<>();
        if (params.get("account")!=null&&params.get("account")!=""){
            query.put("account",params.get("account"));
//            System.out.println(params.get("account"));
        }
        if (params.get("loginTime")!=null&&params.get("loginTime")!=""){
            query.put("login_time",params.get("loginTime"));
        }
        return userLogService.page(query,pageNum);
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserLogEntity userLogEntity){
        return userLogService.save(userLogEntity);
    }
    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody UserLogEntity userLogEntity){
        return userLogService.updateById(userLogEntity);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")Long id){
        return userLogService.deleteById(id);
    }


}
