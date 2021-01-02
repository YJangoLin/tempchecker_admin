package com.lzl.tempchecker_admin.module.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.log.dao.UserLogDao;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.log.service.UserLogService;
import com.lzl.tempchecker_admin.module.sys.dao.UserDao;
import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.sys.service.UserInfoService;
import com.lzl.tempchecker_admin.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public IPage<Map<String,Object>> page(Map<String, Object> params, Integer pageNum) {
        QueryWrapper<UserLogEntity> wrapper = new QueryWrapper<>();
        if (params.get("account")!=null){
            wrapper.like("account", params.get("account"));
        }if (params.get("login_time")!=null){
            wrapper.ge("login_time",params.get("login_time"));
        }
        Integer count = userLogDao.selectCount(wrapper);

        IPage<Map<String, Object>> page;
        if (pageNum==null){
            page = new Page<>(1, 10,count);
        }else {
            page = new Page<>(pageNum, 10,count);
        }
        return userLogDao.selectMapsPage(page,wrapper);
    }
    @Override
    public List<UserLogEntity> findAll() {
        List<UserLogEntity> userLogEntities = userLogDao.selectList(null);
        return userLogEntities;
    }

    @Override
    public UserLogEntity findById(Long id) {
        QueryWrapper<UserLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
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
