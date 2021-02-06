package com.demo.service.impl;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
