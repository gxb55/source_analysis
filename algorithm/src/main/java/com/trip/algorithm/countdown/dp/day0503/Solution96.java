package com.trip.algorithm.countdown.dp.day0503;

/**
 * @author xbguo
 * @createTime 2023年05月03日 12:41:00
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 * 通过次数361,223提交次数509,695
 */
public class Solution96 {
    public static void main(String[] args) {
        int n = 3;
         n = 1;
        int i = numTrees(n);
        System.out.println(i);
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        /**
         * dp[i]= n  N代表的时候n个节点可以组成多少种搜索二叉树
         *
         */
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 假如 i=6 dp[0]*dp[5] +  dp[1]*dp[4]
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
