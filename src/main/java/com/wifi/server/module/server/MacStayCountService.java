package com.wifi.server.module.server;

import com.wifi.server.module.dao.MacStayCountDao;
import com.wifi.server.module.entity.MacStayCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacStayCountService {

    @Autowired
    private MacStayCountDao dao;

    public List<MacStayCount> findList(MacStayCount macStayCount){
        return dao.findList(macStayCount);
    }

    /**
     * 查询平均值
     */
    public MacStayCount findAverage(String studentId, String wid,String dealDate, String grade){
        return dao.findAverage(studentId, wid, dealDate,grade);
    }

    /**
     * 查询班级 所有地点的平均值
     */
    public List<MacStayCount> findAllAverage(String studentId,String dealDate){
        return dao.findAllAverage(studentId,dealDate);
    }

    /**
     * 查询某年各月数据
     */
    public List<MacStayCount> findYearList(String studentId,String year, String wid){
        return dao.findYearList(studentId, year, wid);
    }

    /**
     * 查询某年某地点各月的平均值
     */
    public List<MacStayCount> findWidYearAverage(String studentId,String year, String wid){
        return dao.findWidYearAverage(studentId, year, wid);
    }
}
