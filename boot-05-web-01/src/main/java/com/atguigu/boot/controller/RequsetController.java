package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequsetController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "请求成功");
        request.setAttribute("code", "0");
        return "forward:/success"; //转发到 /success
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        String msg1 = (String) request.getAttribute("msg");
        map.put("anno_code", code);
        map.put("anno_msg", msg);
        map.put("attribute_msg1", msg1);
        return map;
    }

    // 矩阵变量请求
    // 1、语法 /cars/sell;low=34;brand=byd,audi,yd
    // 2、SpringBoot默认禁用了矩阵变量的功能。
    //              手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    @GetMapping("/cars/{path}")
    public Map carsell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

}
