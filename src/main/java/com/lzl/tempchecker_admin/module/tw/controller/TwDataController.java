package com.lzl.tempchecker_admin.module.tw.controller;

import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import com.lzl.tempchecker_admin.module.tw.service.TwDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Zonglin Liang on 2020/12/31.
 * Describe:
 **/
@Controller
@RequestMapping("/tw")
public class TwDataController {
    @Autowired
    TwDataService twDataService;

    @GetMapping("/finAll")
    @ResponseBody
    public Map<String,Object> findAll(){
        Map<String, Object> data = new HashMap<>();
        List<TwDataEntity> Data = twDataService.findAll();
        ArrayList<Double> tempData = new ArrayList<>();
        ArrayList<Double> wpData = new ArrayList<>();
        ArrayList<Date> dateData = new ArrayList<>();
        for (TwDataEntity tw: Data){
            tempData.add(tw.getTp());
            wpData.add(tw.getWp());
            dateData.add(tw.getCreateDate());
        }
        data.put("tData",tempData);
        data.put("wData",wpData);
        data.put("cData",dateData);
        data.put("data", Data);
        return data;
    }

    @GetMapping("/findLast")
    @ResponseBody
    public TwDataEntity findLastOne(){
        return twDataService.getLastData();
    }
    @GetMapping("/findError")
    @ResponseBody
    public List<TwDataEntity> findErrorData(){
        return twDataService.getErrorData();
    }

    @GetMapping("/info")
    @ResponseBody
    public Map<String,Object> getInfo(){
        return twDataService.getInfo();
    }
}
