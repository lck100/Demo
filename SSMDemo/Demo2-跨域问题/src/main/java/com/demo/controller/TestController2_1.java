package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*",allowCredentials = "true")
@Controller
public class TestController2_1 {
    // 测试使用
    @RequestMapping("/setSession2")
    @ResponseBody
    public String setSession(String username,HttpServletRequest request) {
        request.getSession().setAttribute("username",username);
        System.out.println(request.getSession().getId());
        return "已经设置session中的数据";
    }
}
