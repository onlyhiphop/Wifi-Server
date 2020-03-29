package com.wifi.server.module.dao;

import com.wifi.server.module.entity.WifiInfo;

import java.util.List;

/**
 * @author LiaoBaoCai
 * @description: TODO
 * @date 2020/3/28 9:37
 */
public interface WifiInfoDao {

    List<WifiInfo> findList(WifiInfo wifiInfo);
}
