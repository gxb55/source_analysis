package com.trip.algorithm.leet.some.leet2304;

/**
 * @author xbguo
 * @createTime 2023年04月06日 08:23:00
 */
public class Solution1017 {
    public static void main(String[] args) {

    }

    public static String baseNeg2(int n) {
        int[] arr = new int[32];
        int cur = 2;
        int val = n;
        for (int i = 0; i < arr.length; i++) {
            int t = val % 2;
            if (i % 2 == 0) {
                arr[i] = t;
            } else {
                arr[i] = t;
                arr[i + 1]++;
            }
            val = val / 2;
        }
        return "";
    }
}
