package com.tongyl.example.jdemosb.entity;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
