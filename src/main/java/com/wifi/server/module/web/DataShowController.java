package com.wifi.server.module.web;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.wifi.server.common.model.AjaxResult;
import com.wifi.server.common.utils.MyUtil;
import com.wifi.server.module.entity.*;
import com.wifi.server.module.server.MacDsNightService;
import com.wifi.server.module.server.MacStayCountService;
import com.wifi.server.module.server.MacStayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class DataShowController {

    @Autowired
    private MacStayCountService countService;
    @Autowired
    private MacStayTimeService stayTimeService;
    @Autowired
    private MacDsNightService macDsNightService;

    /**
     * 查询行为轨迹
     * @param searchCondition
     * @return
     */
    @RequestMapping(value = "/behavior")
    public AjaxResult behavior(SearchCondition searchCondition) {
        String sid = searchCondition.getSid();
        String date = searchCondition.getDate();

        StudentMac studentMac = new StudentMac();
        studentMac.setStudentId(sid);
        MacStayCount count = new MacStayCount();
        MacStayTime time = new MacStayTime();
        count.setDealDate(date);
        count.setStudentMac(studentMac);
        time.setDealDate(date);
        time.setStudentMac(studentMac);

        List<MacStayCount> countList = countService.findList(count);
        List<MacStayTime> timeList = stayTimeService.findList(time);

        List<MacStayCount> countAverage = countService.findAllAverage(sid, date);
        List<MacStayTime> timeAverage = stayTimeService.findAllAverage(sid, date);

        Dict result  = Dict.create().set("count", countList).set("time", timeList)
                .set("countAverage", countAverage).set("timeAverage", timeAverage);

        return AjaxResult.success(result);
    }

    /**
     * 消费能力
     * @param searchCondition
     * @return
     */
    @RequestMapping(value = "/consume")
    public AjaxResult consume(SearchCondition searchCondition){
        String sid = searchCondition.getSid();

        MacStayCount count = new MacStayCount();
        StudentMac studentMac = new StudentMac();
        studentMac.setStudentId(sid);
        WifiInfo wifiInfo = new WifiInfo();
        count.setWid("2020s");
        count.setWifiInfo(wifiInfo);
        count.setStudentMac(studentMac);

        List<MacStayCount> slist = countService.findList(count);
        int scount = 0;
        for (MacStayCount m :
                slist) {
            scount += Integer.parseInt(m.getComeCount());
        }

        count.setWid("2020c");
        List<MacStayCount> clist = countService.findList(count);
        int ccount = 0;
        for (MacStayCount m :
                clist) {
            ccount += Integer.parseInt(m.getComeCount());
        }

        //食堂平均值
        //班级
        MacStayCount saverage = countService.findAverage(sid, "2020s", null,"clas");
        String clas_savg = null;
        int sclasPeople = 0;
        if(saverage != null){
            clas_savg = saverage.getAverage();
            sclasPeople = saverage.getNumberPeople();
        }
        //系
        MacStayCount facultyList = countService.findAverage(sid, "2020s",null, "faculty");
        String fac_savg = null;
        int sfacultyPeople = 0;
        if (facultyList != null){
            fac_savg = facultyList.getAverage();
            sfacultyPeople = facultyList.getNumberPeople();
        }
        //校
        MacStayCount allList = countService.findAverage(sid, "2020s", null,"all");
        String all_savg = null;
        int sallPeople = 0;
        if (allList != null){
            all_savg = allList.getAverage();
            sallPeople = allList.getNumberPeople();
        }

        //超市平均值
        //班级
        MacStayCount caverage = countService.findAverage(sid, "2020c",null, "clas");
        String clas_cavg = null;
        int cclasPeople = 0;
        if(caverage != null){
            clas_cavg = caverage.getAverage();
            cclasPeople = caverage.getNumberPeople();
        }
        //系里
        MacStayCount facultyCaverage = countService.findAverage(sid, "2020c", null,"faculty");
        String faculty_cavg = null;
        int cfacultyPeople = 0;
        if(facultyCaverage != null){
            faculty_cavg = facultyCaverage.getAverage();
            cfacultyPeople = facultyCaverage.getNumberPeople();
        }
        //校
        MacStayCount allCaverage = countService.findAverage(sid, "2020c", null,"faculty");
        String all_cavg = null;
        int callPeople = 0;
        if(allCaverage != null){
            all_cavg = allCaverage.getAverage();
            callPeople = allCaverage.getNumberPeople();
        }

        Dict dict = Dict.create().set("placeName", "食堂").set("该生", scount).set("班级平均值", clas_savg)
                .set("系平均值", fac_savg).set("校平均值", all_savg);
        Dict dict2 = Dict.create().set("placeName", "超市").set("该生", ccount).set("班级平均值", clas_cavg)
                .set("系平均值", faculty_cavg).set("校平均值", all_cavg);
        List dataList = new ArrayList();
        dataList.add(dict);
        dataList.add(dict2);

        //所占百分比计算
        //食堂
        double sCPonit = scount / (Double.parseDouble(clas_savg) * sclasPeople);
        double sFPoint = scount / (Double.parseDouble(fac_savg) * sfacultyPeople);
        double sAPoint = scount / (Double.parseDouble(all_savg) * sallPeople);
        //超市
        double cCPoint = ccount / (Double.parseDouble(clas_cavg) * cclasPeople);
        double cFPoint = ccount / (Double.parseDouble(faculty_cavg) * cfacultyPeople);
        double cAPoint  = ccount / (Double.parseDouble(all_cavg) * callPeople);


        String clas_Point = String.format("%.2f", (sCPonit + cCPoint)*100 / 2);
        String facu_Point = String.format("%.2f", (sFPoint + cFPoint) * 100 /2);
        String all_Point = String.format("%.2f", (sAPoint + cAPoint) *100 /2);

        Dict resultAjax = Dict.create().set("chart", dataList).
                set("classPoint", clas_Point).set("facultyPoint", facu_Point).set("allPoint", all_Point);

        return AjaxResult.success(resultAjax);
    }


    /**
     * 夜间手机使用情况
     * @param searchCondition
     * @return
     */
    @RequestMapping(value = "/dsNight")
    public AjaxResult dsNight(SearchCondition searchCondition){
        String sid = searchCondition.getSid();
        String year = searchCondition.getYear();
        String month = searchCondition.getMonth();
        StudentMac studentMac = new StudentMac();
        studentMac.setStudentId(sid);
        MacDsNight dsNight = new MacDsNight();
        dsNight.setStudentMac(studentMac);
        if(StrUtil.isNotBlank(year) && StrUtil.isNotBlank(month)){  //查询具体某个月
            dsNight.setDealDate(year + "-" + month);
            List<MacDsNight> dsNightList = macDsNightService.findList(dsNight);
            List<String> dataList = MyUtil.sortDsList(dsNightList);
            return AjaxResult.success(dataList);
        }else{
            if(StrUtil.isNotBlank(year) && StrUtil.isBlank(month)){ //查询一年
                dsNight.setDealDate(searchCondition.getYear());
            }
            List<MacDsNight> dsNightList = macDsNightService.findLocalList(dsNight);
            List<String> dataList = MyUtil.sortDsList(dsNightList);
            return AjaxResult.success(dataList);
        }
    }

    /**
     * 各月数据对比
     * @param searchCondition
     * @return
     */
    @RequestMapping(value = "/allMonth")
    public AjaxResult allMonth(SearchCondition searchCondition){
        String year = searchCondition.getYear();
        String sid = searchCondition.getSid();
        //次数
        List<MacStayCount> yearCountList = countService.findYearList(sid, year);
        Map<String, List<String>> countMonthMapList = MyUtil.getCountMonthMapList(yearCountList);

        //时间
        List<MacStayTime> yearTimeList = stayTimeService.findYearList(sid,year);
        Map<String, List<String>> timeMonthMapList = MyUtil.getTimeMonthMapList(yearTimeList);

        Dict result = Dict.create().set("count", countMonthMapList).set("time", timeMonthMapList);
        return AjaxResult.success(result);
    }
}
