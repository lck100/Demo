package com.demo.test;

import com.demo.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.util.List;

public class JdbcTemplateTest {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");

    @Test
    // 测试插入语句
    public void test01() throws PropertyVetoException {
        // 执行操作
        int row = jdbcTemplate.update("insert into tb_student(name,sdept,birthday) values (?,?,?)", "李四", "物联网工程", "2012-12-03");
        System.out.println(row);
    }

    @Test
    // 测试修改操作
    public void test02() throws PropertyVetoException {
        // 执行操作
        int row = jdbcTemplate.update("update tb_student set name=? where id=?", "王八",1);
        System.out.println(row);
    }

    @Test
    // 测试删除操作
    public void test03() throws PropertyVetoException {
        // 执行操作
        int row = jdbcTemplate.update("delete from tb_student where id=?",3);
        System.out.println(row);
    }

    //聚合查询
    @Test
    public void test04(){
        Long count = jdbcTemplate.queryForObject("select count(*) from tb_student", Long.class);
        System.out.println(count);
    }
    //查询一个
    @Test
    public void test05(){
        Student student= jdbcTemplate.queryForObject("select * from tb_student where name=?", new BeanPropertyRowMapper<Student>(Student.class), "王八");
        System.out.println(student);
    }
    //查询所有
    @Test
    public void test06(){
        List<Student> studentList = jdbcTemplate.query("select * from tb_student", new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(studentList);
    }
}
