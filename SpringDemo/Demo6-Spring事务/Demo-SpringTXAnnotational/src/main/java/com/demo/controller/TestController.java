package com.demo.controller;

import com.demo.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lcl100
 * @create 2021-05-20 10:36
 */
public class TestController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = app.getBean(Service.class);
        service.transfer("zhangsan","lisi",500);
    }
}
