package com.wifi.server.module.dao;

import com.wifi.server.module.entity.MacStayCount;
import com.wifi.server.module.entity.MacStayTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MacStayTimeDao {

    List<MacStayTime> findList(MacStayTime macStayTime);

    /**
     * 查询平均值
     */
    MacStayTime findAverage(@Param("studentId")String studentId, @Param("wid")String wid,@Param("dealDate")String dealDate, @Param("grade")String grade);

    /**
     * 查询班级 所有地点的平均值
     */
    List<MacStayTime> findAllAverage(@Param("studentId")String studentId, @Param("dealDate")String dealDate);

    /**
     * 查询某年各月数据
     */
    List<MacStayTime> findYearList(@Param("studentId")String studentId,@Param("year")String year);

}
