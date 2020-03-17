package com.tunyl.feign;

import feign.Feign;

/**
 * @author create by Tunyl on 2020/1/20
 * @version 1.0
 */
public class FeifnTest {

    public static void main(String[] args) {
        User user =  Feign.builder()
                .target(User.class,"http://localhost:8443");
        String str = user.getUserInfo("Axel");
        System.out.println(str);
    }
}
