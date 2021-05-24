package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.bean.User;
import com.demo.extend.MyBaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-23 11:14
 */
// 继承自己写的MyBaseMapper<T>接口
public interface UserMapper extends BaseMapper<User> {
}
