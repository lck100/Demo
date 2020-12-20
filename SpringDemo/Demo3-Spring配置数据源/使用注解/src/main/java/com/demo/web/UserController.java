package com.demo.web;

import com.demo.config.SpringConfiguration;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class UserController {
    // 原来的测试方式
//    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();
//    }

    // 使用spring集成junit的测试方式
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        userService.save();
    }
}
