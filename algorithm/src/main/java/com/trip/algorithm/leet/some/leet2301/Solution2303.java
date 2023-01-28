package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @date 2023/1/25 12:05
 * @description 2303
 */
public class Solution2303 {
    public static void main(String[] args) {
     // int[][]  brackets = {{3,50},{7,10},{12,25}};int income = 10;
      int[][]  brackets = {{2,28}};int income = 1;
        Solution2303 solution2303 = new Solution2303();
        double v = solution2303.calculateTax(brackets, income);
        System.out.println(v);
    }

    public double calculateTax(int[][] brackets, int income) {
        double sum = 0;
        for (int i = 0; i < brackets.length; i++) {
            int val = brackets[i][0];
            int valM = brackets[i][1];
            double sum1=0;
            if (val > income) {
                if(i==0){
                    sum1=income*valM;
                }else{
                    sum1=(income-brackets[i-1][0])*valM;
                }
                sum+=sum1/100;
                break;
            }else {
                if(i==0){
                    sum1=valM*val;
                }else{
                    sum1=(val-brackets[i-1][0])*valM;
                }
            }
            sum+=sum1/100;
        }
        return sum;
    }
}
