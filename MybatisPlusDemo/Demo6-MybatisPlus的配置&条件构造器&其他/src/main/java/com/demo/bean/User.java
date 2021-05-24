package com.demo.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.demo.enumpackage.SexEnum;

/**
 * @author lcl100
 * @create 2021-05-23 11:12
 */
@TableName("tb_user")
public class User extends Model<User> {
    @TableId(value = "id", type = IdType.AUTO)// 设置id字段为自增长
    private Long id;
    private String username;
    @TableField(fill = FieldFill.INSERT)
    private String password;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer deleted;
    private SexEnum sex;// 设置枚举类型
    // 无参和全参构造器、get和set方法、toString方法

    public User() {
    }

    public User(Long id, String username, String password, String name, Integer age, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                ", sex=" + sex +
                '}';
    }
}
