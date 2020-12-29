package com.lzl.tempchecker_admin.module.log.controller;

import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    public String update(@RequestBody UserLogEntity userLogEntity){
        return userLogService.updateById(userLogEntity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@Param("id")Long id){
        return userLogService.deleteById(id);
    }


}
