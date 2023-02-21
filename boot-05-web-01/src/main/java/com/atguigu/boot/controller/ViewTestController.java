package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model) {

        //Model中的数据会自动放到请求域中，相当于调用了request.setAttribute()
        model.addAttribute("msg", "你好guigu");
        model.addAttribute("link", "http://www.baidu.com");

        //直接写页面的名字，不用路径也不用html后缀
        return "success";
    }
}
