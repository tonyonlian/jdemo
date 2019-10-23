package com.tunyl.refect;

/**
 * @author create by Tunyl on 2019/10/14
 * @version 1.0
 */
public class ClassDemo {
    public static void main(String[] args) {
        String[] strArr = new String[10];
        int[][] twoDimArr = new int[2][3];
        int[] oneDimArr = new int[10];

        Class<? extends String[]> strArrCls = strArr.getClass();
        Class<? extends int[][]> twoDimArrCls = twoDimArr.getClass();
        Class<? extends int[]> oneDimArrCls = oneDimArr.getClass();

        Class<Void> voidCls = void.class;

        Class<Double> doubleCls = double.class;
        Class<Character> charCls = char.class;
        Class<Byte> byteCls = byte.class;
        Class<Integer> intCls = int.class;

    }
}
