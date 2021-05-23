package com.demo.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-23 11:33
 */
public class TestMybatisPlus {
    @Test
    public void testFindAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取UserMapper接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行findAll方法
        List<User> userList = mapper.findAll();
        // 打印结果
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
