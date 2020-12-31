package com.lzl.tempchecker_admin.module.tw.service;

import com.lzl.tempchecker_admin.module.sys.entity.User;
import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;

import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
public interface TwDataService {
    List<TwDataEntity> findAll();

    TwDataEntity getLastData();
}
