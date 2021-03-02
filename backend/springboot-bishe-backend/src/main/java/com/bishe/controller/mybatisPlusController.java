package com.bishe.controller;

import com.bishe.mapper.UserMapper2;
import com.bishe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class mybatisPlusController {
    @Autowired
    private UserMapper2 userMapper2;
    @GetMapping("/selectAllUser")
    public List<User> selectAllUser(){
        return userMapper2.selectList(null);
    }
}
