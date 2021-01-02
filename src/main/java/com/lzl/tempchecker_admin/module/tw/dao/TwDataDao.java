package com.lzl.tempchecker_admin.module.tw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TwDataDao extends BaseMapper<TwDataEntity> {
    @Select("select * from cur_data order by create_date desc limit 0,1")
    TwDataEntity getLastData();
    @Select("select * from cur_data  where tp<10 or tp>40 or wp<0.2 or wp>0.8 order by create_date desc")
    List<TwDataEntity> getErrorData();
}
