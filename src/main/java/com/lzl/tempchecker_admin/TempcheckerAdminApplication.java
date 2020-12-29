package com.lzl.tempchecker_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan({"com.lzl.tempchecker_admin.module.*.dao"})
public class TempcheckerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempcheckerAdminApplication.class, args);
    }

}
