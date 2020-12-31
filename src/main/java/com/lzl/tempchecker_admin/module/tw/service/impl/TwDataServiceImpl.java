package com.lzl.tempchecker_admin.module.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzl.tempchecker_admin.module.tw.dao.TwDataDao;
import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import com.lzl.tempchecker_admin.module.tw.service.TwDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@Service
public class TwDataServiceImpl implements TwDataService {
    @Autowired
    TwDataDao twDataDao;
    @Override
    public List<TwDataEntity> findAll() {
        return twDataDao.selectList(null);
    }

    @Override
    public TwDataEntity getLastData() {
        return twDataDao.getLastData();
    }
}
