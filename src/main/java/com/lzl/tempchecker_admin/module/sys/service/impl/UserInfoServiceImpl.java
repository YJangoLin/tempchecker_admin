package com.lzl.tempchecker_admin.module.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.sys.dao.UserInfoDao;
import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo findById(Long id) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        return userInfoDao.selectOne(wrapper);
    }
}
