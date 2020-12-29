package com.lzl.tempchecker_admin.module.log.dao;

import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLogDaoTest {
    @Autowired
    UserLogService userLogService;
    @Test
    void insert(){
        UserLogEntity userLogEntity = new UserLogEntity();
        userLogEntity.setAccount("后浪");
        userLogEntity.setStatus(1);
        UserLogEntity userLogEntity1 = new UserLogEntity();
        userLogEntity1.setAccount("贺儿");
        userLogEntity1.setStatus(1);
        UserLogEntity userLogEntity2 = new UserLogEntity();
        userLogEntity2.setAccount("后浪");
        userLogEntity2.setStatus(0);
        userLogService.save(userLogEntity);
        userLogService.save(userLogEntity1);
        userLogService.save(userLogEntity2);

    }
    @Test
    void findById(){
        System.out.println(userLogService.findById(1343110180421775361L).toString());
    }
    @Test
    void findAll(){
        userLogService.findAll().forEach(System.out::println);
    }

}