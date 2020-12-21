package com.demo.dao;

import com.demo.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
}
