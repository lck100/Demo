package com.demo.controller;


import com.demo.domain.User;
import com.demo.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller// 把该类放到Spring容器中
public class UserController {

    @RequestMapping(value="/quick22")
    @ResponseBody
    public void save22(@CookieValue(value = "JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    @RequestMapping(value="/quick21")
    @ResponseBody
    public void save21(@RequestHeader(value = "User-Agent",required = false) String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping("quick20")
    @ResponseBody
    public void save20(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("quick19")
    @ResponseBody
    public void save19(Date date){
        System.out.println(date);
    }

    @RequestMapping(value="/quick18/{name}")
    @ResponseBody
    public void save17(@PathVariable(value="name") String username) {
        System.out.println(username);
    }

    @RequestMapping(value="/quick17")
    @ResponseBody
    public void save16(@RequestParam(value="name",required = false,defaultValue = "默认值") String username) {
        System.out.println(username);
    }

    @RequestMapping(value="/quick16")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value="/quick15")
    @ResponseBody
    public void save15(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping(value="/quick14")
    @ResponseBody
    public void save14(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(User user) throws IOException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick11")
    @ResponseBody//期望SpringMVC自动将User转换成json格式的字符串
    public List<User> save11() {
        User user = new User();
        user.setUsername("李四");
        user.setAge(32);
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(user);
        }
        return list;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() {
        User user = new User();
        user.setUsername("李四");
        user.setAge(32);
        return user;
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("张三");
        user.setAge(30);
        //使用json的转换工具将对象转换成json格式字符串在返回
        ObjectMapper objectMapper = new ObjectMapper();
        // 转换成字符串
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"张三\",\"age\":18}";
    }

    @RequestMapping("/quick7")
    @ResponseBody  //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() {
        return "Hello SpringMVC!";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello SpringMVC!");
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request, HttpSession session) {
        request.setAttribute("username", "张三");
        session.setAttribute("username", "张三");
        return "success";
    }

    @RequestMapping("/quick4")
    public String save4(Model model) {
        // 而且不用实例化Model
        // request.setAttribute("username","张三");// 等价于下面一行的代码
        model.addAttribute("username", "张三");
        return "success";
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        // modelAndView作为参数，而不是ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("username", "张三");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick2")
    public ModelAndView save2(HttpServletRequest request) {
        /**
         * Model：模型，作用是封装数据
         * View：视图，作用是展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // addObject(attributeName,attributeValue)表示设置模型数据，attributeName为键名，attributeValue为键值
        // request.setAttribute("username","张三");// 等价于下面一行的代码
        modelAndView.addObject("username", "张三");
        // setViewName(viewName)表示设置视图名称，而viewName表示视图名称
        // 由于在spring-mvc.xml中配置了前后缀的，所以是"success"即可，如果没有设置，则是"/jsp/success.jsp"
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller");
        return "success";
    }
}
