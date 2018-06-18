package com.springboot.studentmanagementsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class SMSController {

    @RequestMapping("/api")
    public String init(){
        log.info("[init]");
        return "index.html";
    }
}
