package com.lzl.tempchecker_admin.enums;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

public enum LoginStatusEnum implements IEnum<Integer> {
    ONLINE(1,"在线"),
    LEAVE(0,"离线");

    private Integer key;
    private String staus;

    LoginStatusEnum(Integer key, String status) {
        this.key = key;
        this.staus =status;
    }

//    public Integer getKey(){
//        return this.key;
//    }
    public Integer getValue(){
        return this.key;
    }
}
