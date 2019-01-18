package com.foxgo.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ControllerAdvice
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //registry.addMapping("/api/**")
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:9527")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")//请求支持的方法
                .allowedHeaders("*")//允许请求头重的header
                //.exposedHeaders("Access-Control-*") //响应头中允许访问的header
                .allowCredentials(true) //是否允许cookie随请求发送，使用时必须指定具体的域
                .maxAge(3600); //预请求的结果的有效期
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false); //url大小不区分
        configurer.setPathMatcher(matcher);
    }

}
