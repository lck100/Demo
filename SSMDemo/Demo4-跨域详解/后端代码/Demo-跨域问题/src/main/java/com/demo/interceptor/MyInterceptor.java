package com.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Origin","*");// "*"表示一个通配符，允许所有域跨域
//        response.addHeader("Access-Control-Allow-Origin","http://127.0.0.1:8848");// 允许指定域名进行跨域
        response.addHeader("Access-Control-Allow-Methods","*");// "*"表示一个通配符，允许所有方法
//        response.addHeader("Access-Control-Allow-Methods","GET");// 允许GET方法跨域
        response.addHeader("Access-Control-Allow-Headers","Content-Type");// 配置后，前端提交json格式的POST请求，也能够跨域成功
        response.addHeader("Access-Control-Max-Age","3600");// 缓存预检命令
        response.addHeader("Access-Control-Allow-Credentials","true");// 允许携带cookie
        return true;
    }
}
