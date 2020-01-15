package com.tunyl.kafang;

import org.apache.commons.math3.distribution.BinomialDistribution;

/**
 * @author create by Tunyl on 2019/11/26
 * @version 1.0
 */
public class dergamma {
    //采样1000次
    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(binomialsampler(100,0.9));
//        }

        BinomialDistribution binomial=new BinomialDistribution(100,0.1869);
        System.out.println(binomial.cumulativeProbability(11220));
    }

    //二项分布采样
    public static double binomialsampler(int trials, double p){
        BinomialDistribution binomial=new BinomialDistribution(trials,p);
        binomial.getNumericalVariance();
        return binomial.sample();
    }

}
