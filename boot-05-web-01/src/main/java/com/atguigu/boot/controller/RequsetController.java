package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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



}
