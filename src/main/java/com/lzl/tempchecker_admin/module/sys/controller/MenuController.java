package com.lzl.tempchecker_admin.module.sys.controller;

import com.lzl.tempchecker_admin.module.sys.entity.MenuEntity;
import com.lzl.tempchecker_admin.module.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@RequestMapping("/menu")
@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/info/{author}")
    @ResponseBody
    public List<MenuEntity> info(@PathVariable(name = "author") String authority){
        System.out.println(authority);
        if (authority.equals("user")){
            return menuService.getUserMenuList();
        }if (authority.equals("admin")){
            return menuService.getMenuList();
        }
        return null;
    }
}
