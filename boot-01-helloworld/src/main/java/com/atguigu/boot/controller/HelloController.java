package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handler01() {
        return "Hello Spring Boot2!" + "你好";
    }

    @Test
    public void handler02() {
        String type = "0";
        // String type = "1";
        // String type = "2";
        String openAccountType = null;
        switch (type) {

            case "0":
                openAccountType = "预开户";
                break;

            case "1":
                openAccountType = "开户配卡";
                break;
            case "2":
                openAccountType = "仅开户不开卡";
                break;
            default:

        }
        System.out.println(openAccountType);

    }

}
