package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lcl100
 * @create 2021-05-20 10:37
 */
public class Dao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void out(String outMan, double money) {
        jdbcTemplate.update("update accounts set account=account-? where name=?",money,outMan);
    }

    public void in(String inMan, double money) {
        jdbcTemplate.update("update accounts set account=account+? where name=?",money,inMan);
    }
}
