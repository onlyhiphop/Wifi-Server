package com.wifi.server.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WifiInfo implements Serializable {
    private String id;
    private String wid;
    private String placeName;
}
