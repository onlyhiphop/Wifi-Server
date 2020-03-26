package com.wifi.server.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MacStayTime implements Serializable {

    private String id;
    private String mac;
    private String wid;
    private String dealDate;
    private String stayDuration;
    private Date createDate;

    private WifiInfo wifiInfo;
    private StudentMac studentMac;

    private String average;    //平均值
    private Integer numberPeople;   //人数
    private String month;
}
