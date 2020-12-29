package com.lzl.tempchecker_admin.module.sys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    UserDao userDao;
    @Test
    void add(){
//        User user = new User();
//        user.setAccount("熊");
//        user.setPassword("B18041714");
//        userDao.insert(user);
        userDao.selectList(null).forEach(System.out::println);
    }
    @Test
    void selectPage(){

        IPage<Map<String, Object>> page = new Page<>(1, 2);
        IPage<Map<String, Object>> iPage = userDao.selectMapsPage(page, null);
        System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());
        List<Map<String, Object>> userList = iPage.getRecords();

        userList.forEach(System.out::println);
    }

}