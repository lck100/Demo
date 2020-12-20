package com.demo.dao.impl;

import com.demo.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("save running...");
    }

    public void init(){
        System.out.println("初始化方法...");
    }

    public void destroy(){
        System.out.println("销毁方法...");
    }
}
