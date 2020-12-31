package com.lzl.tempchecker_admin.module.sys.controller;

import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserInfo userInfo){
        return userInfoService.save(userInfo);
    }

    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestBody UserInfo userInfo){
        return userInfoService.updateById(userInfo);
    }




}
