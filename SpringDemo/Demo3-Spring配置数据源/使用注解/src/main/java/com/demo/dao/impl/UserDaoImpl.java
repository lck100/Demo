package com.demo.dao.impl;

import com.demo.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// <bean id="userDao" class="com.demo.dao.impl.UserDaoImpl"></bean>
// 相当于下面的注解
//@Component("userDao")
// 相当于下面的注解
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}

