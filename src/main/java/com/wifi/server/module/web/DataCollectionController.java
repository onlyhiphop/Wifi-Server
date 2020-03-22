package com.wifi.server.module.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 数据采集Controller
 * @author liaobaocai
 */
@Slf4j
@Controller
@RequestMapping(value = "/wifidata")
public class DataCollectionController {

    private static ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = "/collection", method = RequestMethod.POST)
    @ResponseBody
    public String collection(@RequestParam(value = "data", required = false) String data) throws JsonProcessingException {

        HashMap map = MAPPER.readValue(data, HashMap.class);
        String wid = (String) map.get("id");
        String lat = (String) map.get("lat");
        String lon = (String) map.get("lon");
        String time = DateUtil.format(new Date((String)map.get("time")), "yyyyMMddHHmmss");
        List dataList = (ArrayList)map.get("data");
        for(int i = 0; i < dataList.size(); i++){
            HashMap<String,String> item = (HashMap) dataList.get(i);
            String mac = item.get("mac");
            String range = item.get("range");
            String rssi = item.get("rssi");
            String ds = StrUtil.isBlank(item.get("ds")) == true?"":item.get("ds");
            log.info("{},{},{},{},{},{},{},{}", wid,lat,lon,time,mac,range,rssi,ds);
        }

        return "ok";
    }

    @RequestMapping(value = "dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
