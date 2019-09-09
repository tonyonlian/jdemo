package com.tunyl.refect;

/**
 * @author Created by Tunyl on 2019/9/5.
 * @version 1.0
 */
public class User {

    private int age;
    private String name;
    public User(){

    }
    public User(String name){
        this.name = name;
    }

    private User(int age,String name){
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
