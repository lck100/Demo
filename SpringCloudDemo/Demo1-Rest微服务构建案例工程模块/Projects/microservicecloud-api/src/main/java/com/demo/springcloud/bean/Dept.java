package com.demo.springcloud.bean;

import java.io.Serializable;

/**
 * @author lcl100
 * @create 2021-06-13 22:05
 */
public class Dept implements Serializable {// 微服务必须实现序列化接口
    private Long deptno;//主键
    private String dname;// 部门名称
    private String db_source;// 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到多个数据库

    public Dept() {
    }

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
