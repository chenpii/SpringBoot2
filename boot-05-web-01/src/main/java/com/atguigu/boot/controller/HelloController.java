package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpi
 * @create 2022-10-23 18:44
 */
@RestController
public class HelloController {
    @RequestMapping("/bug.jpg")
    public String hello() {
        return "hello";
    }
}
