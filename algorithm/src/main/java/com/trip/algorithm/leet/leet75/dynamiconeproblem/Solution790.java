package com.trip.algorithm.leet.leet75.dynamiconeproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年09月04日 21:03:00
 */
public class Solution790 {
    public static void main(String[] args) {
          int n = 30;
       // int n = 5;
        int i = Solution790.numTilings(n);
        System.out.println(i);
        System.out.println(Solution790.numTilings1(n));
    }

    public static int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        int mod = 1000000007;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 1});
        list.add(new int[]{2, 1});
        list.add(new int[]{3, 2});
        list.add(new int[]{4, 2});
        int[][] dp = new int[n + 1][4];
        /**
         * 0 全空   00
         * 1 全1   11
         * 2 上1   10
         * 3 下1   01
         */
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0]=dp[i-1][1];
            dp[i][1]=(((dp[i-1][1]+dp[i-1][0])%mod+dp[i-1][3])%mod+dp[i-1][2])%mod;
            dp[i][2]=(dp[i-1][0]+dp[i-1][3])%mod;
            dp[i][3]=(dp[i-1][0]+dp[i-1][2])%mod;
        }
        for (int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][1];
    }

    public static int numTilings1(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        for (int[] arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][3];
    }

    static final int MOD = 1000000007;
}
