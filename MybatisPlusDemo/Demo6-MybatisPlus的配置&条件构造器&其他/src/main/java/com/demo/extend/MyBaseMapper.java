package com.demo.extend;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-05-24 16:29
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {
    // 定义自己想要扩展的方法
    List<T> findAll();
}
