package com.lzl.tempchecker_admin.module.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzl.tempchecker_admin.module.sys.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
public interface UserService {
    List<User> getList(Map<String, Object> params);

    List<User> findAll();

    String updateById(User user);

    String deleteById(Long id);

    String save(User user);

    List<User> selectByMap(Map<String,Object> map);
}
