package com.trip.algorithm.leet.some.leet2303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/3/2 10:30
 * 输入：0.625
 * 输出："0.101"
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 */
public class Solution0502 {
    public static void main(String[] args) {
        //double num = 0.625;
        double num = 0.1;
        String s = printBin(num);
        System.out.println(s);
    }

    public static String printBin(double num) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Double> set = new HashSet<>();
        set.add(num);
        while (num < 1 && num != 0) {
            num = num * 2;
            if (!set.add(num)) {
                return "ERROR";
            }
            if (num >= 1) {
                stringBuilder.append("1");
                num = num - 1.0;
            } else {
                stringBuilder.append("0");
            }
            if(stringBuilder.length()>=32){
                return "ERROR";
            }
        }
        return "0." + stringBuilder;
    }

}
