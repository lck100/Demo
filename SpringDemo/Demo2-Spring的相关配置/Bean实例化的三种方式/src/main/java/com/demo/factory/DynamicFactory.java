package com.demo.factory;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;

public class DynamicFactory {
    // 注意不是static的
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
