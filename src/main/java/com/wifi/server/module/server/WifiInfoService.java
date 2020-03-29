package com.wifi.server.module.server;

import com.wifi.server.module.dao.WifiInfoDao;
import com.wifi.server.module.entity.WifiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiaoBaoCai
 * @description: TODO
 * @date 2020/3/28 9:37
 */
@Service
public class WifiInfoService {
    @Autowired
    private WifiInfoDao dao;

    public List<WifiInfo> findList(WifiInfo wifiInfo){
        return dao.findList(wifiInfo);
    }
}
