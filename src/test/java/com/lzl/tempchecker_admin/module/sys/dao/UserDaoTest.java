package com.lzl.tempchecker_admin.module.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserDao userDao;

    @Test
    void add(){
//        User user = new User();
//        user.setAccount("熊");
//        user.setPassword("B18041714");
//        userDao.insert(user);
//        userDao.selectList(null).forEach(System.out::println);
    }
    @Test
    void selectPage(){

//        IPage<Map<String, Object>> page = new Page<>(1, 2);
//        IPage<Map<String, Object>> iPage = userDao.selectMapsPage(page, null);
//        System.out.println("总页数:" + iPage.getPages());
//        System.out.println("总记录数:" + iPage.getTotal());
//        List<Map<String, Object>> userList = iPage.getRecords();
//
//        userList.forEach(System.out::println);
//        userInfoService.findById(1343110180421775361L);
        Map<String,Object> maps = new HashMap<>();
        maps.put("account","后浪");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(maps);
        Integer count = userDao.selectCount(wrapper);
        IPage<Map<String, Object>> page = new Page<>(1,10,count);
        userDao.selectMapsPage(page,wrapper);
        System.out.println(userService.page(maps,1).toString());
    }

}