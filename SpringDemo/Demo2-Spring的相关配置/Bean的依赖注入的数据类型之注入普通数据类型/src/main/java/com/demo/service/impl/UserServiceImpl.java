package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    // 通过set方法实现依赖注入
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        // 直接调用了，而不需要再生成UserDao对象
        userDao.save();
    }
}
