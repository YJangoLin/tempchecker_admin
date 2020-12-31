package com.lzl.tempchecker_admin.module.tw.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@Data
@TableName("cur_data")
public class TwDataEntity {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private Double tp;

    private Double wp;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableLogic
    private Integer isDeleted;

    public TwDataEntity(Double tp, Double wp) {
        this.tp = tp;
        this.wp = wp;
    }
}
