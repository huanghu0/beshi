package com.bishe.controller;

import com.bishe.mapper.AdminMapper;
import com.bishe.pojo.Admin;
import com.bishe.utils.RandomValidateCodeUtil;
import com.bishe.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
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
    public List<Admin> accountLogin(HttpServletRequest request){
        int account = Integer.parseInt(request.getParameter("account"));
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        //System.out.println(request);
        System.out.println(code.toLowerCase());
        System.out.println(session.getAttribute("code"));
        if(!code.toLowerCase().equals(session.getAttribute("code"))){
            return null;
        }
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
    @RequestMapping("/getImage")
    public String getImageCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-llow-redentials","true");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //1.使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.将验证码放入servletContext作用域
        request.getServletContext().setAttribute("code",code);
        //3.将图片转换成base64
        //字节数组输出流在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组缓冲区中。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //将得到的验证码，使用工具类生成验证码图片，并放入到字节数组缓存区
        VerifyCodeUtils.outputImage(220,60,byteArrayOutputStream,code);
        //使用spring提供的工具类，将字节缓存数组中的验证码图片流转换成Base64的形式
        //并返回给浏览器
        // 存入会话session
        HttpSession session = request.getSession(true);
        //session.setAttribute("code",code.toLowerCase());
        // 删除以前的
        session.removeAttribute("code");
        session.removeAttribute("codeTime");
        session.setAttribute("code", code.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());
//        System.out.println(session);
        return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
    }
}
