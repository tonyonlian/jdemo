package com.tunyl.niodemo;

/**
 * @author create by Tunyl on 2020/1/3
 * @version 1.0
 */
public class TestDemo {
    static class Card{
        String name;
        long length;
    }

    public static void main(String[] args) {
        Card card = new Card();
        card.name ="xxx";
        if(null == card.name){
            System.out.println("name is null");
        }else if(0 == card.length){
            System.out.println("length == 0");
        }
    }
}


