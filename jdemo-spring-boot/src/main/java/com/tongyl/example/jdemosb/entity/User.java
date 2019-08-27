package com.tongyl.example.jdemosb.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Created by Tunyl on 2019/7/26.
 * @version 1.0
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private double money;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public double getMoney() {
//        return money;
//    }
//
//    public void setMoney(double money) {
//        this.money = money;
//    }
}
