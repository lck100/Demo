package com.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lcl100
 * @create 2021-05-23 11:33
 */
public class TestMybatisPlus {

    @Test
    public void testSelectPage() {
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserMapper userMapper = (UserMapper) app.getBean("userMapper");
        // 设定分页参数，第一个参数是页码（从1开始），第二个参数是页显示条数
        Page<User> page = new Page<User>(1L, 2L);
        // 设定筛选条件
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.gt("age", 15);// 查询年龄大于15岁的人
        // 根据条件查询记录
        IPage<User> userPage = userMapper.selectPage(page, null);
        System.out.println("数据总条数：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        // 打印分页记录
        List<User> userList = userPage.getRecords();// 获取分页记录数
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
