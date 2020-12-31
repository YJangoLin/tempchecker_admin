package com.lzl.tempchecker_admin.module.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@Data
@TableName("sys_menu")
public class MenuEntity {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;

    private String name;

    private String path;

    private String component;

    private Long parentId;

    private String author;

    @TableLogic
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(exist = false)
    private List<MenuEntity> children;

    public Integer getPid(){
        if (this.parentId != null) return 1;
        return 0;
    }
}
