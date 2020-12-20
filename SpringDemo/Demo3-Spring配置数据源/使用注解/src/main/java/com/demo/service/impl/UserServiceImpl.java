package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// <bean id="userService" class="com.demo.service.impl.UserServiceImpl"></bean>
// 相当于下面的注解
//@Component("userService")
// 相当于下面的注解
@Service("userService")
// 配置范围
@Scope("singleton")
public class UserServiceImpl implements UserService {
    // 注入普通数据类型，通过@Value
    @Value("张三")
    private String name;

    // <property name="userDao" ref="userDao"/>
    // 相当于下面的注解，即将userDao注入到userService中
    // @Autowired // 按照数据类型从Spring容器中进行匹配的，所以下一行注解可以省略，但如果有多个则不能成功
    // @Qualifier("userDao")// 按照id值从Spring容器中进行匹配，但此处@Qualifier需要结合@Autowired使用
    // 上面四行的注解相当于下面的注解
    @Resource(name = "userDao")// 相当于@Qualifier+@Autowired
    private UserDao userDao;
    // 使用注解后，便可以不同set方法了
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    public void save() {
        userDao.save();
        System.out.println(name);
    }

    @PostConstruct// 使用注解来实现Bean的初始化方法
    public void init(){
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy// 使用注解来实现Bean的销毁方法
    public void destroy(){
        System.out.println("Service对象的销毁方法");
    }
}
