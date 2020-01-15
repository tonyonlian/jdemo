package com.tunyl.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author create by Tunyl on 2019/12/10
 * @version 1.0
 */
public class NumberPair<U extends Number, V extends Number> extends Pair<U,V> {

    public NumberPair(U first, V second) {
        super(first, second);
    }
    public double sum() {
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    public static void main(String[] args) {
        NumberPair<Integer, Double> dd = new NumberPair<>(2, 4.2);
        double sum =  dd.sum();
        System.out.println("sum = " + sum);
        double max = dd.max(new Double[]{2.1, 3.4, 6.7});
        System.out.println("max= "+max);
    }
    public static <T extends  Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}
