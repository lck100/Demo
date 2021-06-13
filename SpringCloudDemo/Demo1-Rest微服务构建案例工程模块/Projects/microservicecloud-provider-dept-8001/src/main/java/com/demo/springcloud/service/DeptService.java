package com.demo.springcloud.service;

import com.demo.springcloud.bean.Dept;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-06-13 22:19
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
