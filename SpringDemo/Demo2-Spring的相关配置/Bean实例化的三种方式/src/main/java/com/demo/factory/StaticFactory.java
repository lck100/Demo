package com.demo.factory;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
