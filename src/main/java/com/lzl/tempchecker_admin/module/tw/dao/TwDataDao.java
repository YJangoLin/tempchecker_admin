package com.lzl.tempchecker_admin.module.tw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import org.apache.ibatis.annotations.Select;

public interface TwDataDao extends BaseMapper<TwDataEntity> {
    @Select("select * from cur_data order by create_date desc limit 0,1")
    TwDataEntity getLastData();
}
