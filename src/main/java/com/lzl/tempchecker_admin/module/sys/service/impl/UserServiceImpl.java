package com.lzl.tempchecker_admin.module.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.sys.dao.UserDao;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getList(Map<String, Object> params) {
        List<User> userList1 = new ArrayList<>();
        IPage<Map<String, Object>> page = new Page<>(1, 2);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(params);
        IPage<Map<String, Object>> iPage = userDao.selectMapsPage(page, wrapper);
        System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());
        List<Map<String, Object>> userList = iPage.getRecords();
        for (Map<String,Object> map: userList){
            User user = JSON.parseObject(JSON.toJSONString(map), User.class);
            userList1.add(user);
        }

        return userList1;
    }
}