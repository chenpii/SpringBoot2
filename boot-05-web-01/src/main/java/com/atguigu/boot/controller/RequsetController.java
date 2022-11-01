package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "helloworld");
        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";

    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code,
                       HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        String msg1 = (String) request.getAttribute("msg");

        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("anno_code", code);
        map.put("anno_msg", msg);
        map.put("attribute_msg1", msg1);

        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        return map;
    }


}
