package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * 用于table页面的跳转
 */
@Controller
public class TableController {
    @Autowired
    IUserService userService;

    @GetMapping("/basic_table")
    public String basic_table() {
        // int i = 10 / 0; //制造异常
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //分页遍历表格
        // List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "1234444"), new User("wangwu", "888888"));
        // model.addAttribute("users", users);

        //从数据库中查出user表中的用户进行展示
        List<User> list = userService.list();
        // model.addAttribute("users", list);

        //分页查询数据 pn为传入的当前页
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果 传入翻页对象和查询条件
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        model.addAttribute("page", page);


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
