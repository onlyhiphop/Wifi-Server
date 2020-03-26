package com.wifi.server.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MacDsNight {
    private String id;
    private String mac;
    private String nightTime;
    private String dsCount;
    private String dealDate;

    private StudentMac studentMac;
}
