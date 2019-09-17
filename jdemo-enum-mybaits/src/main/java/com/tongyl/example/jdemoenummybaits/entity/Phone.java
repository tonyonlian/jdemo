package com.tongyl.example.jdemoenummybaits.entity;

/**
 * @author Created by Tunyl on 2019/9/4.
 * @version 1.0
 */
public class Phone<T> {
    private T key;
    public Phone(T key){
        this.key =key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
