package com.wifi.server.module.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = {"", "index"})
    public String dashboard() {
        return "static/dashboard";
    }

    @RequestMapping(value = "realTime")
    public String realTime(){
        return "static/realTime";
    }
}
