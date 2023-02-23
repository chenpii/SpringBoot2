package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 用于table页面的跳转
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "1234444"), new User("wangwu", "888888"));
        model.addAttribute("users", users);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
