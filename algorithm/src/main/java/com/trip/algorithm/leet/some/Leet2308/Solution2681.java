package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年08月01日 21:20:00
 */
public class Solution2681 {
    public static void main(String[] args) {
        // int[] arr = {2, 1, 4};
        //  int[] arr = {1, 1, 1};
        int[] arr = {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206};

        int i = sumOfPower(arr);
        System.out.println("res:" + i);
    }

    public static int sumOfPower(int[] nums) {
        int mod = 1000000007;
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long v = nums[i] * nums[i];
            for (int j = i; j >= 0; j--) {
                int v1 = nums[j];
                long v2 = ((v % mod) * (v1 % mod)) % mod;
                long v4 = (int) Math.pow(2, i - j - 1);
                long v5 = v4 == 0 ? 1 : v4;
                long v3 = (v2 * v5 % mod) % mod;
                res = (int) (res + v3);
                System.out.println(v3);
                res = res % mod;
            }
        }
        return res;
    }
}
