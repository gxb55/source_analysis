package com.trip.algorithm.leet.l24.l02;

public class Solution1186 {
    public static void main(String[] args) {

    }

    public int maximumSum(int[] arr) {
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[arr.length][2];
        // 以1结尾且删除了一个元素的最大只是多少,正常不存在，因为是空数组
        dp[0][0] = 0;
        // 以1结尾，且未删除任何元素的最大值是多少
        dp[0][1] = arr[0];
        res = Math.max(res, dp[0][1]);
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            // 把当前元素删除了，或者之前删除过了，这里只能加起来
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] + v);
            // 未删除，之前就是未删除，则把当前元素也加上，；或者从当前元素开始也是未删除
            dp[i][1] = Math.max(dp[i - 1][1] + v, v);
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
