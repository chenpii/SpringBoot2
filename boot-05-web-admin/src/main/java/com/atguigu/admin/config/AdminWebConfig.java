package com.atguigu.admin.config;


import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有/**，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，并写明拦截的范围
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")    // /** 拦截所有请求，包括静态资源
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**");    //放行的请求
    }
}
