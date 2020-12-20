package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService {
    // 通过构造函数实现依赖注入
    private UserDao userDao;

    // 无参构造函数
    public UserServiceImpl() {

    }

    // 带参数的构造函数
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        // 直接调用了，而不需要再生成UserDao对象
        userDao.save();
    }
}
