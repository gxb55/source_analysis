package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/1/14  16:36
 * @description 丑数 II
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1690
 * 通过次数109,632提交次数188,564
 */
public class Solution264 {
    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        int i = solution264.nthUglyNumber(11);
        System.out.println(i);
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(5 * dp[p5], Math.min(2 * dp[p2], 3 * dp[p3]));
            dp[i]=min;
            if (min == 5 * dp[p5]) {
                p5++;
            }
            if (min == 2 * dp[p2]) {
                p2++;
            }
            if (min == 3 * dp[p3]) {
                p3++;
            }
        }
        return dp[n - 1];
    }
}
