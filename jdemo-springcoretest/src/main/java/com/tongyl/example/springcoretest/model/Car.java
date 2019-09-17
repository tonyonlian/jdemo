package com.tongyl.example.springcoretest.model;

/**
 * @author Created by Tunyl on 2019/9/15.
 * @version 1.0
 */
public class Car {
    private String color;
    private String brand;
    private String maxSpeed;

    public Car() {
        System.out.println("Init Bean: Car.class");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + "color='" + color + '\'' + ", brand='" + brand + '\'' + ", maxSpeed='" + maxSpeed + '\'' + '}';
    }
}
