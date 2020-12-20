package com.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfiguration.class})
// 表明该类是一个配置类
@Configuration
// <context:property-placeholder location="classpath:jdbc.properties"/>
// 等价于下面的注解，加载properties文件
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    // <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
    // <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test"></property>
    // <property name="user" value="root"></property>
    // <property name="password" value="root"></property>
    // 等价于下面的注解，注入普通属性
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    //        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
    //        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test"></property>
    //        <property name="user" value="root"></property>
    //        <property name="password" value="root"></property>
    // </bean>
    // 等价于下面的注解
    @Bean("dataSource")// Spring回将当前方法的返回值以指定名称dataSource存储到Spring容器中
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        // 引入properties文件存放连接字符串后，可以使用${}符号获取通过上面的@Value注解
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Test
    public void test01() {
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}
