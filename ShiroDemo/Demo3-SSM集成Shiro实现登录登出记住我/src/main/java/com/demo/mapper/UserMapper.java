package com.demo.mapper;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserByUsername(@Param("username")String username);
}
