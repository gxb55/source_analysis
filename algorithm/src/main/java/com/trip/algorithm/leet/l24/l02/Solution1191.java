package com.trip.algorithm.leet.l24.l02;

import java.util.Arrays;

public class Solution1191 {
    public static void main(String[] args) {
        int[] arr = {1, 2};

        int k = 3;
        int i = kConcatenationMaxSum(arr, k);
        System.out.println(i);
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {

        if (Arrays.stream(arr).allMatch(x -> x > 0)) {
            int sum = Arrays.stream(arr).sum();
            long v = 0;
            for (int i = 0; i < k; i++) {
                v = v + sum;
                v = v % 1000000007;
            }
            return (int) v;
        } else if (Arrays.stream(arr).allMatch(x -> x < 0)) {
            return 0;
        }
        int t = arr.length * (k);
        int[] dp = new int[t];
        dp[0] = Math.max(0, arr[0]);
        long res = dp[0];
        for (int i = 1; i < t; i++) {
            int j = i % arr.length;
            dp[i] = Math.max(dp[i - 1] + arr[j], arr[j]);
            res = Math.max(res, dp[i]);
        }
        res = res % 1000000007;
        return (int) res;
    }
}
