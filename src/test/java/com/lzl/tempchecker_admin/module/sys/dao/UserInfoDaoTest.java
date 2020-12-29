package com.lzl.tempchecker_admin.module.sys.dao;

import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoDaoTest {
    @Autowired
    UserInfoDao userInfoDao;
    @Test
    void save(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(20);
        userInfo.setEmail("2717973485@qq.com");
        userInfo.setTelephone("15903037385");
        userInfo.setUserId(1343110180421775361L);
        userInfoDao.insert(userInfo);
    }

}