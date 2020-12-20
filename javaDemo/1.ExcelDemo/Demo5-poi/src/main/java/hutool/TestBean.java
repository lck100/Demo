package hutool;

import java.util.Date;

public class TestBean {
    private int id;
    private String name;
    private String password;
    private float score;
    private boolean isPass;
    private Date date;

    public TestBean() {
    }

    public TestBean(int id, String name, String password, float score, boolean isPass, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.score = score;
        this.isPass = isPass;
        this.date = date;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", isPass=" + isPass +
                ", date=" + date +
                '}';
    }
}
