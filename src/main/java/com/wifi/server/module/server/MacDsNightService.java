package com.wifi.server.module.server;

import com.wifi.server.module.dao.MacDsNightDao;
import com.wifi.server.module.entity.MacDsNight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacDsNightService {

    @Autowired
    private MacDsNightDao dao;

    public List<MacDsNight> findList(MacDsNight macDsNight){
        return dao.findList(macDsNight);
    }

    public List<MacDsNight> findLocalList(MacDsNight dsNight) {
        return dao.findLocalList(dsNight);
    }
}
