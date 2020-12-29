package com.lzl.tempchecker_admin.module.sys.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao extends BaseMapper<User> {
    IPage<User> selectMapPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
