package com.bishe.controller;

import com.bishe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloWorldController2 {
    @Autowired
    private User user;
    @RequestMapping("/index")
    public String index(Model model){
        user.setSex("m");
        user.setAge(22);
        user.setName("黄虎");
        model.addAttribute(user);
        return "index";
    }
}
