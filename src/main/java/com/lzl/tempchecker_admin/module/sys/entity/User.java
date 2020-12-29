package com.lzl.tempchecker_admin.module.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.lzl.tempchecker_admin.enums.LoginStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by Zonglin Liang on 2020/12/27.
 * Describe:
 **/
@Data
@TableName("sys_user")
public class User {
    @TableId
    private Long id;
    @NotEmpty(message = "账户不能为空字符串")
    @NotNull(message = "用户名不能为空")
    private String account;
    @NotNull(message = "密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$",message = "密码至少包含 数字和英文，长度6-20")
    private String password;
    @TableField(value = "status")
    private Integer status;
    @TableLogic
    private Integer isDeleted;
    private Long infoId;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    public String getStatusValue(){
        if (status==0){
            return "离线";
        }else {
            return "在线";
        }
    }
}
