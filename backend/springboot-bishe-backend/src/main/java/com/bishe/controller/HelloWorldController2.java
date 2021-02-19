package com.bishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController2 {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
