package com.demo.web;

import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过<bean>标签的ID从容器中获取实例对象
        UserService userService1 = (UserService) app.getBean("userService");
        // 通过Class类型从容器中获取实例对象
        UserService userService2 = app.getBean(UserService.class);
        userService1.save();
        userService2.save();
    }
}
