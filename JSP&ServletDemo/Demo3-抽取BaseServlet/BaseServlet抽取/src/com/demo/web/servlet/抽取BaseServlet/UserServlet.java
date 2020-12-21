package com.demo.web.servlet.抽取BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void register(HttpServletRequest request, HttpServletResponse response) {
        // 注册逻辑
        System.out.println("注册逻辑");
    }

    public void activeUser(HttpServletRequest request, HttpServletResponse response) {
        // 激活用户逻辑
        System.out.println("激活用户逻辑");
    }

    public void exit(HttpServletRequest request, HttpServletResponse response) {
        // 退出登录逻辑
        System.out.println("退出登录逻辑");
    }

    public void findUser(HttpServletRequest request, HttpServletResponse response) {
        // 发现用户逻辑
        System.out.println("发现用户逻辑");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        // 登录逻辑
        System.out.println("登录逻辑");
    }
}
