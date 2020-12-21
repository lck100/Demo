package com.demo.web.servlet.抽取BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 不需要访问到该servlet
// 如果不抽取BaseServlet，那么所有请求都需要写一个XXXServlet.java类
// 如：ActiveUserServlet.java、ExitServlet.java、FindUserServlet.java、LoginServlet.java、RegisterServlet.java
public class BaseServlet extends HttpServlet {
    // 只需要实现service()方法，然后在该方法中分发请求
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 分发方法即分发activeUser、exit、findUser、login、register等方法
        // 完成方法分发
        // 1.获取请求路径
        String uri = req.getRequestURI();//   /demo/user/login
        System.out.println("请求uri: "+uri);
        // 2.获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);// login
        System.out.println("方法名称："+methodName);
        // 3.获取方法对象Method，根据方法名称反射方法对象
        //获取方法
        try {
            // getMethod(String methodName, Object... args); 传入方法名称和参数
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //4.执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
