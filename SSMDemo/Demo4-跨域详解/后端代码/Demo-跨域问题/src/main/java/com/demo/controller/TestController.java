package com.demo.controller;

import com.demo.domain.Result;
import com.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    @RequestMapping("/test1")
    @ResponseBody
    public String test1() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test1成功！"));
        System.out.println("请求/test1成功！");
        return result;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(String callback) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test2成功！"));
        System.out.println("请求/test2成功！");
        return callback + "(" + result + ")";
    }

    // 我所使用的版本不支持下面这种语法
    /*@RequestMapping("/test2")
    @ResponseBody
    public String test2(String callback) throws IOException {
        MappingJacksonValue mjv=new MappingJacksonValue(new Result("请求/test2成功！"));
        mjv.setJsonpFunction(callback);
        System.out.println("请求/test2成功！");
        return mjv.toString();
    }*/

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(@RequestBody User user) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test3成功！"));
        System.out.println("请求/test3成功！获得的数据为："+user);
        return result;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4(HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test4成功！"));
        System.out.println("请求/test4成功！打印cookie数据如下：");
        // 打印cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"="+cookie.getValue());
        }
        return result;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public String test5(HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test4成功！"));
        System.out.println("请求/test5成功！打印Headers如下：");
        String selfHeader1 = request.getHeader("self-header1");
        String selfHeader2 = request.getHeader("self-header2");
        System.out.println(selfHeader1+"\t\t"+selfHeader2);
        return result;
    }

    @RequestMapping("/test6")
    @ResponseBody
    public String test6() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test6成功！"));
        System.out.println("请求/test6成功！");
        return result;
    }

    @RequestMapping("/test7")
    @ResponseBody
    public String test7() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test7成功！"));
        System.out.println("请求/test7成功！");
        return result;
    }

    @CrossOrigin
    @RequestMapping("/test8")
    @ResponseBody
    public String test8() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test8成功！"));
        System.out.println("请求/test8成功！");
        return result;
    }

    @RequestMapping("/test9")
    @ResponseBody
    public String test9() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test9成功！"));
        System.out.println("请求/test9成功！");
        return result;
    }

    @RequestMapping("/test10")
    @ResponseBody
    public String test10() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(new Result("请求/test10成功！"));
        System.out.println("请求/test10成功！");
        return result;
    }
}
