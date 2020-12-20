package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();

    public void save() {
        userDao.save();
    }

    public void update() {
        userDao.update();
    }

    public void delete() {
        userDao.delete();
    }
}
