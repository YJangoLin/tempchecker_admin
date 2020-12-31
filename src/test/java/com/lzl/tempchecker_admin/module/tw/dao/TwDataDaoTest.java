package com.lzl.tempchecker_admin.module.tw.dao;

import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TwDataDaoTest {
    @Autowired
    TwDataDao twDataDao;

    @Test
    void add(){
        for (int i=0; i < 20; i++){
            Random random = new Random();
            double temp = 20*random.nextDouble()+10;
            double wp = 0.3+5*random.nextDouble();
            twDataDao.insert(new TwDataEntity(temp,wp));
        }
        twDataDao.selectList(null).forEach(System.out::println);
        System.out.println(twDataDao.getLastData());
    }

}