package com.tunyl.generics;

import java.io.FileInputStream;

/**
 * @author create by Tunyl on 2019/12/9
 * @version 1.0
 */
public class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("老马", 100);
        String name = pair.getFirst();
        Integer age = pair.getSecond();
        System.out.println("name="+name+", age="+age);

    }

}
