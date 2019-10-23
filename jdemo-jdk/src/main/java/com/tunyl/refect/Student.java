package com.tunyl.refect;

import java.util.Date;

/**
 * @author create by Tunyl on 2019/10/16
 * @version 1.0
 */
public class Student {
    @Lable("姓名")
    private String name;
    @Lable("出生日期")
    @Format(pattern = "yyyy/MM/dd")
    private Date birthday;
    @Lable("分数")
    private Double score;

    public Student(String name, Date birthday, Double score) {
        this.name = name;
        this.birthday = birthday;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Student st = new Student("小小", new Date(), 80.5d);
        System.out.println(SimpleFormatter.format(st));
    }
}
