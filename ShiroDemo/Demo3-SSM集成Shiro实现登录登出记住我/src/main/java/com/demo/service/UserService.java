package com.demo.service;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User selectUserByUsername(String username);
}
