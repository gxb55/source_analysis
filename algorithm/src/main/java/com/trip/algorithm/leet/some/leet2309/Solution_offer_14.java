package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/14 15:34
 * n =
 * 120
 * <p>
 * 输出
 * 977185619
 * 预期结果
 * 953271190
 */
public class Solution_offer_14 {
    public static void main(String[] args) {
        Solution_offer_14 s = new Solution_offer_14();
        int n = 120;
        int i = s.cuttingRope1(n);
        System.out.println(i);
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], (i - j) * j);
                // 一段分为j，另一段分为n段 dp[i - j]
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        long[] dp = new long[n + 1];
        dp[2] = 1;
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], ((i - j) * j) % 1000000007);
                // 一段分为j，另一段分为n段 dp[i - j]
                dp[i] = Math.max(dp[i], (dp[i - j] * j) % 1000000007);
                dp[i] = dp[i] % 1000000007;
            }
        }
        return (int) dp[n];
    }
}
