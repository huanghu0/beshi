package com.bishe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    //查询数据库的所有信息
//    @GetMapping("/userlist")
//    public List<Map<String,Object>> userList(){
//        String sql = "select * from user";
//        return jdbcTemplate.queryForList(sql);
//    }
//    @GetMapping("/adduser")
//    public String addUser(){
//        String sql = "insert into bishe.user(name,age,sex) values('何怡',23,'f')";
//        jdbcTemplate.update(sql);
//        return "你好插入成功";
//    }
}
