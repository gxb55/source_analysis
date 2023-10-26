package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/23 11:15
 */
public class Solution2678 {
    public static void main(String[] args) {
        String[] arr={"7868190130M7522","5303914400F9211","9273338290F4010"};
        int i = countSeniors(arr);
        System.out.println(i);
    }
    public static int countSeniors(String[] details) {
        int count=0;
        for (String x:details){
            String substring = x.substring(11, 13);
            Integer integer = Integer.valueOf(substring);
            if(integer>60){
                count++;
            }
        }
        return count;
    }
}
