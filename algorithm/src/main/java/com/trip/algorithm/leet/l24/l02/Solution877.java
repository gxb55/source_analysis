package com.trip.algorithm.leet.l24.l02;

public class Solution877 {
    public static void main(String[] args) {
        Solution877 solution877 = new Solution877();
        int[] arr = {5, 3, 4, 5};
        boolean b = solution877.stoneGame1(arr);
        System.out.println(b);
    }

    /**
     * 5 3 4 5
     * <p>
     * 5 0 0 0
     * 0 3 0 0
     * 0 0 4 0
     * 0 0 0 5
     * <p>
     * dp(2,3)=dp(2,2),dp(3,3)
     */
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        if (len == 2) {
            return true;
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = piles[i] - dp[i + 1][j];
                int right = piles[j] - dp[i][j - 1];
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[0][len - 1] > 0;
    }

    public boolean stoneGame1(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }

}
