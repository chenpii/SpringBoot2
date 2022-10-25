package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    // /car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam List<String> inters,
                                      @RequestParam Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
        // map.put("id", id);
        // map.put("username", name);
        // map.put("pv", pv);
        // map.put("userAgent", userAgent);
        // map.put("headers", headers);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String context) {
        Map<String, Object> map = new HashMap<>();
        map.put("context", context);
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
