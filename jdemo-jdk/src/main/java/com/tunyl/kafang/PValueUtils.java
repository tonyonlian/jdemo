package com.tunyl.kafang;

import java.util.Arrays;

/**
 * @author create by Tunyl on 2019/11/20
 * @version 1.0
 */
public class PValueUtils {

    public static void main(String[] args) {

        System.out.println(chisqr2pValue(10,15.99));
     //   System.out.println(ChiSquare(207,231,282,242));
        double[][] data = {{19,24},{34,10}};
        double[][] expect = doExpect(data);
        double chiSquare = chiSquare(data,expect);
        System.out.println(chiSquare);
        double corChiSquare = corChiSquare(data, expect);
        System.out.println(corChiSquare);
        double mutiChiSquare = mutiCoOrRateChiSquare(data);
        System.out.println(mutiChiSquare);
        double p = chisqr2pValue(1,corChiSquare);
        System.out.println("===================");
        System.out.println(p);
        System.out.println(1-p);


    }

    public double doChiSquare(double[][]data,int rowNum,int columnNum){

        //计算自由度
        int dof =  dof(rowNum,columnNum);
        if(dof ==-1){
            throw new RuntimeException("非法的实验数据");

        }
        //计算理论期望
        double[][] expect = doExpect(data);
        double chiSquValue = 0;
        if (dof == 1 || isExpectLessThan5(expect)) {
            chiSquValue = corChiSquare(data, expect);
        }else{
            chiSquValue = chiSquare(data, expect);
        }

        return chiSquValue;

    }


    private boolean isExpectLessThan5(double[][] expect){
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[0].length; j++) {
                if(expect[i][j]<5){
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * 计算自由度
     * @param rowNum 行数
     * @param columnNum 列数
     * @return
     */
    public static int dof(int rowNum,int columnNum){
        if(rowNum<0 || columnNum<0){
            return -1;
        }
        return (rowNum-1)*(columnNum-1);
    }


    /**
     * 计算理论期望
     * @param data
     * @return
     */

    public static double[][] doExpect(double[][] data) {
        double[] nR = new double[data.length];
        double[] nC = new double[data[0].length];
        double total = 0;
        for(int i=0; i<data.length;i++){
            for(int j=0; j<data[i].length;j++){
                nR[i] += data[i][j];
                nC[j] += data[i][j];
                total += data[i][j];
            }

        }
        double[][] expect = new double[data.length][data[0].length];
        for (int i = 0; i < expect.length; i++) {
            for (int j = 0; j < expect[i].length; j++) {
                expect[i][j]= nR[i]*nC[j]/total;
            }
        }

        return expect;
    }

    /**
     * 实用于两组以上的率或百分比的差别的显著性检验
     * @param data
     * @return
     */
    public static double mutiCoOrRateChiSquare(double[][] data){
        double[] nR = new double[data.length];
        double[] nC = new double[data[0].length];
        double total = 0;
        for(int i=0; i<data.length;i++){
            for(int j=0; j<data[i].length;j++){
                nR[i] += data[i][j];
                nC[j] += data[i][j];
                total += data[i][j];
            }

        }
        double chiSquValue =0;
        double temp = 0;

        for(int i=0;i<data.length;i++){
            for (int j = 0; j < data[i].length; j++) {
                temp += Math.pow(data[i][j],2)/(nR[i]*nC[j]);
            }
        }
        chiSquValue = total *(temp-1);
        return chiSquValue;

    }

    /**
     * 修改卡方（当自由度等于1，当 1<理论期望<5  n>40 需要修正
     * @param data
     * @param expect
     * @return
     */
    public static double corChiSquare(double[][] data, double[][] expect) {
        double value = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                value += Math.pow((data[i][j]-expect[i][j]-0.5),2)/expect[i][j];
            }
        }

        return value;
    }

    /**
     * 计算卡方
     * @param data
     * @param expect
     * @return
     */
    public static double chiSquare(double[][] data, double[][] expect) {
        double value = 0;
        for (int i = 0; i < data.length; i++) {
            for(int j=0; j<data[i].length;j++){
                value += Math.pow((data[i][j] - expect[i][j]),2)/expect[i][j];
            }
        }
        return value;
    }










//    public static double ChiSquare(double...values) {
//        int n = values.length;
//        double[] O = new double[n];
//        double[] E = new double[n];
//        double[] D = new double[n];
//        double[] OESQ = new double[n];
//        double[] OESQE = new double[n];
//
//        double oSum = 0;
//        double OESQESum = 0;
//        for (int i = 0; i < n; i++) {
//            O[i] = values[i];
//            oSum = oSum + values[i];
//        }
//        for (int i = 0; i < n; i++) {
//            E[i] = oSum / n;
//            D[i] = O[i] - (oSum / n);
//            OESQ[i] = Math.pow((O[i] - (oSum / n)), 2);
//            OESQE[i] = Math.pow((O[i] - (oSum / n)), 2) / (oSum / n);
//            OESQESum = OESQESum + Math.pow((O[i] - (oSum / n)), 2) / (oSum / n);
//        }
//        return OESQESum;
//    }

    /**
     *计算p_value
     * @param dof 自由度
     * @param chi_squared 卡方值
     * @return
     */

    public static double chisqr2pValue(int dof, double chi_squared) {
        if (chi_squared < 0 || dof < 1) {
            return 0.0;
        }
        double k = ((double) dof) * 0.5;
        double v = chi_squared * 0.5;
        if (dof == 2) {
            return Math.exp(-1.0 * v);
        }
        double incompleteGamma = log_igf(k, v);
        // 如果过小或者非数值或者无穷
        if (Math.exp(incompleteGamma) <= 1e-8
                || Double.isNaN(Math.exp(incompleteGamma))
                || Double.isInfinite(Math.exp(incompleteGamma))) {
            return 1e-14;
        }
        double gamma = Math.log(getApproxGamma(k));
        incompleteGamma -= gamma;
        if (Math.exp(incompleteGamma) > 1) {
            return 1e-14;
        }
        double pValue = 1.0 - Math.exp(incompleteGamma);
        return (double) pValue;
    }




    public static double getApproxGamma(double n) {
        // RECIP_E = (E^-1) = (1.0 / E)
        double RECIP_E = 0.36787944117144232159552377016147;
        // TWOPI = 2.0 * PI
        double TWOPI = 6.283185307179586476925286766559;
        double d = 1.0 / (10.0 * n);
        d = 1.0 / ((12 * n) - d);
        d = (d + n) * RECIP_E;
        d = Math.pow(d, n);
        d *= Math.sqrt(TWOPI / n);
        return d;

    }

    public static double log_igf(double s, double z) {
        if (z < 0.0) {
            return 0.0;
        }
        double sc = (Math.log(z) * s) - z - Math.log(s);
        double k = KM(s, z);
        return Math.log(k) + sc;
    }

    private static double KM(double s, double z) {
        double sum = 1.0;
        double nom = 1.0;
        double denom = 1.0;
        double log_nom = Math.log(nom);
        double log_denom = Math.log(denom);
        double log_s = Math.log(s);
        double log_z = Math.log(z);
        for (int i = 0; i < 1000; ++i) {
            log_nom += log_z;
            s++;
            log_s = Math.log(s);
            log_denom += log_s;
            double log_sum = log_nom - log_denom;
            sum += Math.exp(log_sum);
        }
        return sum;
    }




}



