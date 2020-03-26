package com.wifi.server.module.dao;

import com.wifi.server.module.entity.MacDsNight;

import java.util.List;

public interface MacDsNightDao {

    List<MacDsNight> findList(MacDsNight macDsNight);

    List<MacDsNight> findLocalList(MacDsNight dsNight);

}
