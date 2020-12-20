package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// 把该类放到Spring容器中
public class UserController {
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller ");
        return "success";
    }
}
