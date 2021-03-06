package com.bishe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.bishe.mapper")
public class SpringbootBisheBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBisheBackendApplication.class, args);
    }
}
