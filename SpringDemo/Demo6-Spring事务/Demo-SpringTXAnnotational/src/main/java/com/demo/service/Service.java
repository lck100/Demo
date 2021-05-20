package com.demo.service;

import com.demo.dao.Dao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lcl100
 * @create 2021-05-20 10:37
 */
@Transactional
public class Service {
    private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void transfer(String outMan, String inMan, double money) {
        dao.out(outMan, money);
        int i = 1 / 0;// 人为制造异常
        dao.in(inMan, money);
    }
}
