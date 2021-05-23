package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.bean.User;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-23 11:14
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}
