package easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class UserData {
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("密码")
    private String password;
    @ExcelProperty("生日")
    private Date birthday;

    public UserData() {
    }

    public UserData(String name, String password, Date birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }

    public UserData(int id, String name, String password, Date birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
