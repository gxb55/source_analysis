package com.trip.algorithm.leet.some.leet2310;

import java.math.BigInteger;

/**
 * @author xbguo
 * @date 2023/10/20 19:02
 */
public class Solution2525 {
    public static void main(String[] args) {
       int  length =2909;

        int width =
                3968;
        int height =
                3272;
        int mass =
                727;

        String s = categorizeBox(length, width, height, mass);
        System.out.println(s);
    }

    /**
     * @param length
     * @param width
     * @param height
     * @param mass
     * @return
     */
    public static String categorizeBox(int length, int width, int height, int mass) {
        BigInteger sum=new BigInteger(length+"").multiply(new BigInteger(width+"").multiply(new BigInteger(height+"")));
        Boolean bulkyFlag= false;
        Boolean heavyFlag= false;
        BigInteger subtract = sum.subtract(new BigInteger("1000000000"));
        boolean b = subtract.compareTo(new BigInteger("0")) >= 0 ? true : false;
        if(length>=10000||width>10000||height>10000||b){
            bulkyFlag=true;
        }
        if(mass>=100){
            heavyFlag=true;
        }
        if(bulkyFlag&&heavyFlag){
            return "Both";
        }else if(!bulkyFlag&&!heavyFlag){
            return "Neither";
        }else if(bulkyFlag&&!heavyFlag){
            return "Bulky";
        }else{
            return "Heavy";
        }
    }
}
