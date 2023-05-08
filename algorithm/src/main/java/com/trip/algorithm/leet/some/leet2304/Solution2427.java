package com.trip.algorithm.leet.some.leet2304;

/**
 * @author xbguo
 * @createTime 2023年04月05日 21:54:00
 */
public class Solution2427 {
    public static void main(String[] args) {
        int a = 12, b = 6;
        int i = commonFactors(a, b);
        System.out.println(i);
    }

    public static int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int res = 0;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                res++;
            }
        }
        return res;
    }
}
