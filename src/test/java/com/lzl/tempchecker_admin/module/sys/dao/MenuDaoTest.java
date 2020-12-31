package com.lzl.tempchecker_admin.module.sys.dao;

import com.lzl.tempchecker_admin.module.sys.entity.MenuEntity;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuDaoTest {

    @Autowired
    MenuService menuService;
    @Autowired
    MenuDao menuDao;
    @Test
    void add(){
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setComponent("menu");
        menuEntity.setName("日志信息");
        menuEntity.setPath("/page3");
        menuDao.insert(menuEntity);
        MenuEntity menuEntity1 = new MenuEntity();
        menuEntity1.setComponent("logininfo");
        menuEntity1.setName("用户日志信息");
        menuEntity1.setPath("/logininfo");
        menuDao.insert(menuEntity1);
        MenuEntity menuEntity2 = new MenuEntity();
        menuEntity2.setComponent("menu");
        menuEntity2.setName("异常检测");
        menuEntity2.setPath("/page4");
        menuDao.insert(menuEntity2);
        MenuEntity menuEntity3 = new MenuEntity();
        menuEntity3.setComponent("analysis");
        menuEntity3.setName("异常数据分析展示");
        menuEntity3.setPath("/analysis");
        menuDao.insert(menuEntity3);
    }

    @Test
    void show(){
        menuService.getMenuList().forEach(System.out::println);

    }

}