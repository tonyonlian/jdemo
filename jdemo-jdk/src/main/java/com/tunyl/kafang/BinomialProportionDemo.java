package com.tunyl.kafang;

import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.inference.AlternativeHypothesis;
import org.apache.commons.math3.stat.inference.BinomialTest;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.apache.commons.math3.stat.inference.TTest;
import org.apache.commons.math3.stat.interval.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author create by Tunyl on 2019/11/26
 * @version 1.0
 */
public class BinomialProportionDemo {
   public static void demo(int numClicks, int numImpression) {
        List<BinomialConfidenceInterval> methods = Arrays.asList(
                new NormalApproximationInterval(),
                new ClopperPearsonInterval(),
                new WilsonScoreInterval(),
                new AgrestiCoullInterval());

        double alpha = 0.05;

        System.out.println("---");

        for (BinomialConfidenceInterval method : methods) {
            String name = method.getClass().getSimpleName();

            try {
                ConfidenceInterval ci = method.createInterval(numImpression, numClicks, 1 - alpha);
                System.out.printf("%s: %s\n", name, ci.toString());

            } catch (Exception e) {
                e.printStackTrace();
                System.out.printf("%s: Cannot calculate confidence interval\n", name);
            }
        }
    }

    public static void main(String[] args) {
        demo(228,1220);
        demo(258,1315);
        Frequency f = new Frequency();

        AlternativeHypothesis a = AlternativeHypothesis.TWO_SIDED;
        BinomialDistribution bt = new BinomialDistribution(1315,0.1962);
        System.out.println("==============");
        System.out.println(bt.getNumericalVariance());
        BinomialTest b = new BinomialTest();
        System.out.println(b.binomialTest(1315,258,0.1869,a));
        ChiSquareTest c = new ChiSquareTest();
        long[][] count = {{228L,992L},{258L,1057L}};
       double x = c.chiSquare(count);
        System.out.println("p= "+x);

        System.out.println(  c.chiSquareTest(count));





    }


}
