package com.demo.dao.impl;

import com.demo.dao.UserDao;

public class UserDaoImpl implements UserDao {
    // 使用set方法注入普通数据类型
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save() {
        System.out.println(username+"========"+age);
        System.out.println("save running...");
    }
}
