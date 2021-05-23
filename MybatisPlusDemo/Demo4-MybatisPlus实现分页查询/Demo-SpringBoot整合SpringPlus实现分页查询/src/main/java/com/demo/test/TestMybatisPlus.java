package com.demo.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lcl100
 * @create 2021-05-23 11:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisPlus {

    // 注入UserMapper
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage);
        for (User user : userIPage.getRecords()) {
            System.out.println(user);
        }
    }
}
