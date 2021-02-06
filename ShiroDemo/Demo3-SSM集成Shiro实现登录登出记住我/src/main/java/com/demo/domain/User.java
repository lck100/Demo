package com.demo.domain;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private int state;

    public User() {
    }

    public User(int id, String username, String password, int state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                '}';
    }
}
