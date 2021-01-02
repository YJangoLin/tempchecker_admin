package com.lzl.tempchecker_admin.module.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzl.tempchecker_admin.module.tw.dao.TwDataDao;
import com.lzl.tempchecker_admin.module.tw.entity.TwDataEntity;
import com.lzl.tempchecker_admin.module.tw.service.TwDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zonglin Liang on 2020/12/30.
 * Describe:
 **/
@Service
public class TwDataServiceImpl implements TwDataService {
    @Autowired
    TwDataDao twDataDao;
    @Override
    public List<TwDataEntity> findAll() {
        QueryWrapper<TwDataEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_date");
        wrapper.last("limit 0,10");
        return twDataDao.selectList(wrapper);
    }

    @Override
    public TwDataEntity getLastData() {
        return twDataDao.getLastData();
    }


    @Override
    public List<TwDataEntity> getErrorData() {
        return twDataDao.getErrorData();
    }

    @Override
    public Map<String, Object> getInfo() {
        Map<String,Object> info = new HashMap<>();
        double minTp = 100.0,minWp = 100.0;
        double maxTp = 0.0,maxWp = 0.0;
        List<TwDataEntity> twDataEntities = twDataDao.selectList(null);
        double avgTp = 0.0;
        double avgWp = 0.0;
        TwDataEntity lastData = twDataDao.getLastData();
        for (TwDataEntity twDataEntity :twDataEntities){
            if (twDataEntity.getTp()<minTp){
                minTp = twDataEntity.getTp();
            }
            if (twDataEntity.getTp()>maxTp){
                maxTp = twDataEntity.getTp();
            }
            if (twDataEntity.getWp()>maxWp){
                maxWp = twDataEntity.getWp();
            }
            if (twDataEntity.getTp()<minWp){
                minWp = twDataEntity.getWp();
            }
            avgTp += twDataEntity.getTp();
            avgWp += twDataEntity.getWp();
        }
        avgTp = avgTp/(twDataEntities.size());
        avgWp = avgWp/(twDataEntities.size());
        info.put("avgTp", String.format("%.2f", avgTp));
        info.put("avgWp", String.format("%.2f", avgWp));
        info.put("curTp", lastData.getTp());
        info.put("curWp", lastData.getWp());
        info.put("minTp", minTp);
        info.put("maxTp", maxTp);
        info.put("minWp", minWp);
        info.put("maxWp", maxWp);
        double disTp = maxTp -minTp;
        double disWp = maxWp - minWp;
        info.put("disTp", String.format("%.2f", disTp));
        info.put("disWp", String.format("%.2f", disWp));
        String tip = "";
        if (lastData.getTp()<10.0){
            tip = " 出门时请多穿衣物注意保暖，防止气温下降给你的身体带来不适";
        }else if (lastData.getTp()>10 && lastData.getTp()<20){
            tip = " 温度适宜适合户外运动，记得出去活动一下哦";
        }else {
            tip = " 白天尽量避免或减少户外活动,室外高温作业人员在户外工作时，须采取有效防晒措施，防止皮肤灼伤，此外，还应及时补充水分，防止中暑。";
        }
        if (lastData.getWp()<0.2){
            tip = tip+" 当前室内空气较为干燥,请注意适当调节室内湿度，保持一定的空气湿度<";
        }else if (lastData.getWp()>=0.2 && lastData.getWp()<=0.8){
            tip = tip+" 当前室内空气良好，为避免不适请注意保持室内湿度正常";
        }else {
            tip = tip+" 当前室内较为潮湿，请注意适当调节室内湿度，保持在20%~80%,适当降低室内湿度";
        }
        if (disTp >10){
            tip = tip+" 昼夜温差极大，极易发生感冒，请特别注意增减衣服保暖防寒";
        }

        info.put("tip",tip);
        return info;
    }
}
