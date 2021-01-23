package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*",allowCredentials = "true")
@Controller
public class TestController3_2 {
    // 测试使用
    @RequestMapping("/setCookie2")
    @ResponseBody
    public String setCookie2(HttpServletResponse response){
        Cookie cookie=new Cookie("myCookie","我的cookie");
        response.addCookie(cookie);
        return "设置cookie成功！";
    }

    @RequestMapping("getCookie2")
    @ResponseBody
    public String getCookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"="+cookie.getValue());
        }
        return "获取cookie";
    }
}
