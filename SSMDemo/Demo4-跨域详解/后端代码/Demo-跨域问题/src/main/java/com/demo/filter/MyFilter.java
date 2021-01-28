package com.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 转换为HttpServletResponse类型
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        // 设置响应头
//        response.addHeader("Access-Control-Allow-Origin","*");// "*"表示一个通配符，允许所有域跨域
//        response.addHeader("Access-Control-Allow-Origin","http://127.0.0.1:8848");// 允许指定域名进行跨域
        String origin=request.getHeader("Origin");
        if(origin!=null||!origin.equals("")){
            response.addHeader("Access-Control-Allow-Origin",origin);// 允许指定域名进行跨域
        }
        response.addHeader("Access-Control-Allow-Methods","*");// "*"表示一个通配符，允许所有方法
//        response.addHeader("Access-Control-Allow-Methods","GET");// 允许GET方法跨域
        String header = request.getHeader("Access-Control-Request-Headers");
        if(header!=null||!header.equals("")){
            response.addHeader("Access-Control-Allow-Headers",header);
        }
//        response.addHeader("Access-Control-Allow-Headers","Content-Type,self-header1,self-header2");// 配置后，前端提交json格式的POST请求，也能够跨域成功
        response.addHeader("Access-Control-Max-Age","3600");// 缓存预检命令
        response.addHeader("Access-Control-Allow-Credentials","true");// 允许携带cookie
        System.out.println("filter....");// 证明执行了过滤器方法
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
