package com.bishe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//添加跨域配置类
@Configuration
public class corsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")

                .allowedOrigins("*")

                .allowCredentials(true)

                .allowedMethods("GET", "POST", "DELETE", "PUT")

                .maxAge(3600);
    }
}
