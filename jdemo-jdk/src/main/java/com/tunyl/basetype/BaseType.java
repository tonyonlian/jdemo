package com.tunyl.basetype;

/**
 * 基本类型
 * @author create by Tunyl on 2020/3/11
 * @version 1.0
 */
public class BaseType {
    public static void main(String[] args) {
        Boolean b = Boolean.valueOf("true");
        Float f = Float.valueOf("123.45f");

        boolean b1 = Boolean.parseBoolean("true");
        float f1 = Float.parseFloat("123.45f");

        System.out.println(Boolean.toString(true));
        System.out.println(Float.toString(123.45f));

        //整数的进制表示

        System.out.println(Integer.toBinaryString(12345));
        System.out.println(Integer.toHexString(12345));
        System.out.println(Integer.parseInt("3039",16));
    }
}
