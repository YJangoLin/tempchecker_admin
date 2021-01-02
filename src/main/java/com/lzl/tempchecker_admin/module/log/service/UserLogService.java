package com.lzl.tempchecker_admin.module.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lzl.tempchecker_admin.module.log.entity.UserLogEntity;
import com.lzl.tempchecker_admin.module.sys.entity.User;

import java.util.List;
import java.util.Map;

public interface UserLogService {
    IPage<Map<String,Object>> page(Map<String, Object> params, Integer pageNum);

    List<UserLogEntity> findAll();

    UserLogEntity findById(Long id);

    String save(UserLogEntity userLogEntity);

    String updateById(UserLogEntity userLogEntity);

    String deleteById(Long id);
}
