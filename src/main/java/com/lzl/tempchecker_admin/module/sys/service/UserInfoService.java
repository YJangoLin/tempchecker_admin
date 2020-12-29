package com.lzl.tempchecker_admin.module.sys.service;

import com.lzl.tempchecker_admin.module.sys.entity.UserInfo;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
public interface UserInfoService {
    UserInfo findById(Long id);
}
