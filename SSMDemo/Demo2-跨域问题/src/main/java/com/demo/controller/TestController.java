package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    // 测试使用
    @RequestMapping("/getSession")
    @ResponseBody
    public String getSession(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        if(username==null){
            return "获取session中的数据失败！";
        }else {
            return "获取session中的数据成功，其中的数据是："+username;
        }
    }
    // 测试使用
    @RequestMapping("/setSession")
    @ResponseBody
    public String setSession(String username, HttpServletRequest request) {
        request.getSession().setAttribute("username",username);
        return "已经设置session中的数据";
    }
}
