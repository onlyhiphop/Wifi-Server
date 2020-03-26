package com.wifi.server.common.utils;
import java.util.ArrayList;

import cn.hutool.core.collection.CollUtil;
import com.wifi.server.module.entity.MacDsNight;

import java.util.List;

/**
 * 自定义的工具类
 */
public class MyUtil {

    /**
     * 将ds的时间排序
     */
    public static List<String> sortDsList(List<MacDsNight> dsList){
        String[] sortNight = new String[]{"0","0","0","0","0","0","0"};
        List<MacDsNight> sortList = new ArrayList<>();
        for (MacDsNight n :
                dsList) {
            String nightTime = n.getNightTime();
            String dsCount = n.getDsCount();
            if("23:00".equals(nightTime)){
                sortNight[0] = dsCount;
            }else if ("24:00".equals(nightTime)){
                sortNight[1] = dsCount;
            }else if("01:00".equals(nightTime)){
                sortNight[2] = dsCount;
            }else if("02:00".equals(nightTime)){
                sortNight[3] = dsCount;
            }else if("03:00".equals(nightTime)){
                sortNight[4] = dsCount;
            }else if("04:00".equals(nightTime)){
                sortNight[5] = dsCount;
            }else if("05:00".equals(nightTime)){
                sortNight[6] = dsCount;
            }
        }
        return CollUtil.newArrayList(sortNight);
    }


}
