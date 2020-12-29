package com.lzl.tempchecker_admin.module.log.service;

import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.sys.entity.User;

import java.util.List;

public interface UserLogService {
    List<UserLogEntity> findAll();

    UserLogEntity findById(Long id);

    String save(UserLogEntity userLogEntity);

    String updateById(UserLogEntity userLogEntity);

    String deleteById(Long id);
}
