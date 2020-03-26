package com.wifi.server.module.dao;

import com.wifi.server.module.entity.MacStayCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MacStayCountDao {

    List<MacStayCount> findList(MacStayCount macStayCount);

    /**
     * 查询某个地点平均值
     */
    MacStayCount findAverage(@Param("studentId")String studentId, @Param("wid")String wid,@Param("dealDate")String dealDate, @Param("grade")String grade);

    /**
     * 查询班级 所有地点的平均值
     */
    List<MacStayCount> findAllAverage(@Param("studentId")String studentId,@Param("dealDate")String dealDate);

    /**
     * 查询某年各月数据
     */
    List<MacStayCount> findYearList(@Param("studentId")String studentId,@Param("year")String year);
}
