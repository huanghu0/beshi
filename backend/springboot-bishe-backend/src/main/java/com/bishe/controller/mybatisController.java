package com.bishe.controller;

import com.bishe.mapper.Usermapper;
import com.bishe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//@RestController
public class mybatisController {
//    @Autowired
//    private Usermapper usermapper;
//    @GetMapping("/queryuserlist")
//    public List<User> queryUserList(){
//        List<User> userlist = usermapper.queryUserList();
//        return userlist;
//    }
//    @GetMapping("/queryuserbyid")
//    public User queryUserById(){
//        return usermapper.queryUserById(2);
//    }
//    @GetMapping("/adduser")
//    public int adduser(){
//        return usermapper.addUser(new User(1,"黄虎","m",22));
//    }
//    @GetMapping("/updateuser")
//    public int updateUser(){
//        return usermapper.updateUser(new User(2,"文艳","f",23));
//    }
//    @GetMapping("/deleteuser")
//    public int deleteUser(){
//        return usermapper.deleteUser(2);
//    }
}
