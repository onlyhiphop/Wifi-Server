package com.wifi.server.module.dao;

import com.wifi.server.module.entity.StudentMac;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMacDao {

    List<StudentMac> findList(StudentMac studentMac);

    StudentMac findByStuentId(@Param("studentId")String studentId);
}
