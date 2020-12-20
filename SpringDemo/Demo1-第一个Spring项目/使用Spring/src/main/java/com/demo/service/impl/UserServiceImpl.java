package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    public static void main(String[] args) {
        // 测试
        new UserServiceImpl().save();
        new UserServiceImpl().update();
        new UserServiceImpl().delete();
    }

    public void save() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }

    public void update() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.update();
    }

    public void delete() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.delete();
    }
}
