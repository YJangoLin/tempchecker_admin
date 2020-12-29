package com.lzl.tempchecker_admin.module.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzl.tempchecker_admin.module.log.dao.UserLogDao;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.dao.UserDao;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    UserLogDao userLogDao;

    final String result = "操作成功";
    @Override
    public List<UserLogEntity> findAll() {
        List<UserLogEntity> userLogEntities = userLogDao.selectList(null);
        return userLogEntities;
    }

    @Override
    public UserLogEntity findById(Long id) {
        QueryWrapper<UserLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("uid",id);
        return userLogDao.selectOne(wrapper);
    }

    @Override
    public String save(UserLogEntity userLogEntity) {
        userLogDao.insert(userLogEntity);
        return result;
    }

    @Override
    public String updateById(UserLogEntity userLogEntity) {
        userLogDao.updateById(userLogEntity);
        return result;
    }

    @Override
    public String deleteById(Long id) {
        userLogDao.deleteById(id);
        return result;
    }
}
