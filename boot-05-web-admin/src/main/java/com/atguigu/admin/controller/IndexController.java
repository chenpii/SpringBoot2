package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 访问登录页
     *
     * @return
     */
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login";
    }

    /**
     * 登录请求
     *
     * @param user
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
            //登录成功，user信息放到session里
            session.setAttribute("loginUser", user);
            return "redirect:main.html";//避免刷新页面重复提交表单，使用重定向到main页面
        } else {
            model.addAttribute("msg", "用户名密码错误");
            return "login";
        }

    }

    /**
     * 主页面
     *
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/main.html")//main页面刷新
    public String mainPage(HttpSession session, Model model) {
        //校验是否登录状态，否则回到login页
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }

}
