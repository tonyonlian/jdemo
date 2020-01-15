package com.tongyl.example.jdemo.entity;

/**
 * @author create by Tunyl on 2019/12/24
 * @version 1.0
 */
public class User {
    private Long id;
    private String email ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
