package com.lzl.tempchecker_admin.module.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzl.tempchecker_admin.module.sys.entity.MenuEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuDao extends BaseMapper<MenuEntity> {
    @Select("select * from sys_menu")
    List<MenuEntity> getMuneList();

    @Select("select * from sys_menu where author='user'")
    List<MenuEntity> getUserMuneList();
}
