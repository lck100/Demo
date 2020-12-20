package com.demo.dao.impl;

import com.demo.dao.UserDao;
import com.demo.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    // 使用set方法注入集合类型
    private List<String> strList;
    private Map<String, User> map;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
        System.out.println(strList);
        System.out.println(map);
        System.out.println(properties);
        System.out.println("save running......");
    }
}
