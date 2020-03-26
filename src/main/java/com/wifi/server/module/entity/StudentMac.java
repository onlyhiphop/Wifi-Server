package com.wifi.server.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentMac {
    private String id;
    private String facultyId;   //院系
    private String classId;     //班级
    private String studentId;   //学号
    private String studentName; //姓名
    private String mac;         //mac地址
    private String delFlag;
}
