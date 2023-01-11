package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月13日 10:58:00
 */
public class Solution790 {
    public static void main(String[] args) {
        Solution790 solution790 = new Solution790();
        int x=30;
        int i = solution790.numTilings(x);
        System.out.println(i);
    }
    public int numTilings1(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }

    public int numTilings(int n) {
        int[][] dp = new int[n+1][5];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0]=dp[i-1][3];
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%MOD;
            dp[i][3]=(((dp[i-1][0])%MOD+(dp[i-1][2])%MOD)%MOD+(dp[i-1][3]%MOD+dp[i-1][1]%MOD)%MOD)%MOD;
        }
        return dp[n][3];
    }
    static final int MOD = 1000000007;

}
