package com.demo.springcloud.dao;

import com.demo.springcloud.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lcl100
 * @create 2021-06-13 22:18
 */
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}