package com.lzl.tempchecker_admin.module.sys.service;

import com.lzl.tempchecker_admin.module.sys.entity.MenuEntity;
import com.lzl.tempchecker_admin.module.sys.entity.User;

import java.util.List;

public interface MenuService {
    List<MenuEntity> getMenuList();

    List<MenuEntity> getUserMenuList();
}
