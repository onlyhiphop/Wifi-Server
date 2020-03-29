package com.wifi.server.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCondition {
    private String sid;
    private String date;
    private String year;
    private String month;
    private String wid;
}
