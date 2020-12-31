package com.lzl.tempchecker_admin.module.sys.service.impl;

import com.lzl.tempchecker_admin.module.sys.dao.MenuDao;
import com.lzl.tempchecker_admin.module.sys.entity.MenuEntity;
import com.lzl.tempchecker_admin.module.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    //建立树形结构
    public List<MenuEntity> builTree(List<MenuEntity> menuList){
        List<MenuEntity> treeMenus =new ArrayList<>();
        for(MenuEntity menuNode : getRootNode(menuList)) {
            menuNode=buildChilTree(menuNode,menuList);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private MenuEntity buildChilTree(MenuEntity pNode,List<MenuEntity> menuList){
        List<MenuEntity> chilMenus =new  ArrayList<MenuEntity>();
        for(MenuEntity menuNode : menuList) {
            if(menuNode.getParentId()!=null && menuNode.getParentId().equals(pNode.getId())) {
                System.out.println("true");
                chilMenus.add(buildChilTree(menuNode,menuList));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<MenuEntity> getRootNode(List<MenuEntity> menuList) {
        List<MenuEntity> rootMenuLists =new ArrayList<MenuEntity>();
        for(MenuEntity menuNode : menuList) {
            if(menuNode.getPid()==0) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

    @Override
    public List<MenuEntity> getMenuList() {
        List<MenuEntity> sysDeptAllData = menuDao.getMuneList();
        List<MenuEntity> menuDeptlist = builTree(sysDeptAllData);
        return menuDeptlist;
    }

    @Override
    public List<MenuEntity> getUserMenuList() {
        List<MenuEntity> sysDeptAllData = menuDao.getUserMuneList();
        List<MenuEntity> menuDeptlist = builTree(sysDeptAllData);
        return menuDeptlist;
    }
}
