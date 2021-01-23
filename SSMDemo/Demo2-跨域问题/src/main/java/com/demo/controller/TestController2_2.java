package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*",allowCredentials = "true")
@Controller
public class TestController2_2 {
    // 测试使用
    @RequestMapping("/getSession2")
    @ResponseBody
    public String getSession(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        System.out.println(request.getSession().getId());
        if(username==null){
            return "获取session中的数据失败！";
        }else {
            return "获取session中的数据成功，其中的数据是："+username;
        }
    }
}
