package com.wifi.server.common.utils;
import java.util.*;

import cn.hutool.core.collection.CollUtil;
import com.wifi.server.module.entity.MacDsNight;
import com.wifi.server.module.entity.MacStayCount;
import com.wifi.server.module.entity.MacStayTime;

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


    public static List<String> getCountMonthData(List<MacStayCount> lists, String flag){
        String[] sortMonth = new String[12];
        for(int i = 0; i < 12; i++){
            sortMonth[i] = "0";
        }
        for (MacStayCount count :
                lists) {
            if("0".equals(flag)){
                sortMonth[Integer.parseInt(count.getMonth()) - 1] = count.getComeCount();
            }else if("1".equals(flag)){
                sortMonth[Integer.parseInt(count.getMonth()) - 1] = count.getAverage();
            }
        }
        return CollUtil.newArrayList(sortMonth);
    }

    public static List<String> getTimeMonthData(List<MacStayTime> lists, String flag){
        String[] sortMonth = new String[12];
        for(int i = 0; i < 12; i++){
            sortMonth[i] = "0";
        }
        for (MacStayTime t :
                lists) {
            if("0".equals(flag)){
                sortMonth[Integer.parseInt(t.getMonth()) - 1] = t.getStayDuration();
            }else if("1".equals(flag)){
                sortMonth[Integer.parseInt(t.getMonth()) - 1] = t.getAverage();
            }

        }
        return CollUtil.newArrayList(sortMonth);
    }


    //    /**
//     * 提取count全年十二个月的数据
//     */
//    public static Map<String, List<String>> getCountMonthMapList(List<MacStayCount> lists){
//        Map<String, ArrayList<MacStayCount>> map = new HashMap<>();
//        for (MacStayCount c:
//                lists) {
//            String placeName = c.getWifiInfo().getPlaceName();
//            map.put(placeName, new ArrayList<MacStayCount> ());
//        }
//        for (MacStayCount c :
//                lists) {
//            ArrayList<MacStayCount> macStayCounts = map.get(c.getWifiInfo().getPlaceName());
//            macStayCounts.add(c);
//        }
//        Map<String, List<String>> resultMonth = new HashMap<>();
//        Set<String> keySet = map.keySet();
//        for (String k:
//             keySet) {
//            resultMonth.put(k, getCountMonthData(map.get(k)));
//        }
//        return resultMonth;
//    }

    //    /**
//     * 提取全年十二个月的数据
//     */
//    public static Map<String, List<String>> getTimeMonthMapList(List<MacStayTime> lists){
//        Map<String, ArrayList<MacStayTime>> map = new HashMap<>();
//        for (MacStayTime c:
//                lists) {
//            String placeName = c.getWifiInfo().getPlaceName();
//            map.put(placeName, new ArrayList<MacStayTime> ());
//        }
//        for (MacStayTime c :
//                lists) {
//            ArrayList<MacStayTime> macStayCounts = map.get(c.getWifiInfo().getPlaceName());
//            macStayCounts.add(c);
//        }
//        Map<String, List<String>> resultMonth = new HashMap<>();
//        Set<String> keySet = map.keySet();
//        for (String k:
//                keySet) {
//            resultMonth.put(k, getTimeMonthData(map.get(k)));
//        }
//        return resultMonth;
//    }
}
