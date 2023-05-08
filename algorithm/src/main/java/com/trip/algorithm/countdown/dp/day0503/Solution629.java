package com.trip.algorithm.countdown.dp.day0503;

/**
 * @author xbguo
 * @createTime 2023年05月03日 13:59:00
 * 629. K个逆序对数组
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * <p>
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 * 示例 2:
 * <p>
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释:
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 * 说明:
 * <p>
 * n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
 * 通过次数22,258提交次数43,503
 */
public class Solution629 {
    public static void main(String[] args) {
        // int n = 3, k = 0;
        //   int n = 3, k = 1;
        //  int n = 1, k = 1;
       //
        // int n = 3, k = 2;
        int n = 3, k = 3;
        int i = kInversePairs(n, k);
        System.out.println(i);
    }

    public static int kInversePairs(int n, int k) {
        int mod = 100000007;
        if (k == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] = (dp[i][j] % mod + dp[i - 1][l] % mod) % mod;
                }
            }
        }
        return dp[n][k];
    }
}
