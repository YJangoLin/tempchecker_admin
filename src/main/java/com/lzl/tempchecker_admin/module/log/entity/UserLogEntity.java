package com.lzl.tempchecker_admin.module.log.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Zonglin Liang on 2020/12/29.
 * Describe:
 **/
@Data
@TableName("sys_user_log")
@NoArgsConstructor
public class UserLogEntity {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;
    @NotNull
    @NotEmpty
    private String account;

    private Integer status;
    @TableField(fill = FieldFill.INSERT)
    private Date loginTime;
    @TableLogic
    private Integer isDeleted;

    private String operation;


    public UserLogEntity(@NotNull @NotEmpty String account, Integer status, String operation) {
        this.account = account;
        this.status = status;
        this.operation = operation;
    }
}
