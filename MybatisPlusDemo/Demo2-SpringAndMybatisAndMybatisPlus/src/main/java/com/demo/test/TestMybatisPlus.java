package com.demo.test;

import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-23 11:33
 */
public class TestMybatisPlus {

    @Test
    public void testFindAll() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
