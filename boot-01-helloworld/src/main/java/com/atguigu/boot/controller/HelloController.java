package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpi
 * @create 2022-10-17 20:25
 */
// @Controller
// @ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handler01() {
        return "Hello Spring Boot2!" + "你好";
    }


}
