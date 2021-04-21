package com.bishe.controller;

import com.bishe.mapper.AdminMapper;
import com.bishe.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private Admin admin;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private List<Admin> res;
    @RequestMapping("/addAdmin")
    public String addAdmin(String name,String password,String telnum){
        int account = (int) ((Math.random() * 9 + 1) * Math.pow(10, 8 - 1));
        List<Admin> result1 = adminMapper.selectByAccount(account);
        while (!result1.isEmpty()){
            account = (int) ((Math.random() * 9 + 1) * Math.pow(10, 8 - 1));
            result1 = adminMapper.selectByAccount(account);
        }
        List<Admin> result2 = adminMapper.selectByTelnum(telnum);
        if(!result2.isEmpty()){
           return "你的电话号码已经存在用户，请换一个电话号码";
        }
        admin.setAccount(account);
        admin.setName(name);
        admin.setPassword(password);
        admin.setTelnum(telnum);
        try {
            adminMapper.insert(admin);
        }catch (Exception e){
            return "注册失败!";
        }
        return "注册成功,你的账号为:"+account+"请你务必记住";
    }
    @RequestMapping("/accountlogin")
    public List<Admin> accountLogin(int account,String password){

        try {
            res =  adminMapper.selectByAccount(account,password);
        }catch (Exception e){
            return null;
        }
        if(res.isEmpty()){
            return null;
        }
        return res;
    }
}
