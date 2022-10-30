package com.trip.algorithm.leet.some.leet2208;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年08月21日 15:33:00
 */
public class Solution279 {
    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        //int n = 12;
        //  int n = 13;
        int n = 1;
        int i = solution279.numSquares(n);
        System.out.println(i);
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (true) {
            if (i * i > n) {
                break;
            }
            list.add(i * i);
            i++;
        }
        int[][] dp = new int[list.size()][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = j + 1;
        }
        int max = -1;
        for (int j = 1; j < dp.length; j++) {
            for (int k = 0; k < dp[j].length; k++) {
                int cur = list.get(j);
                if (k > cur - 1) {
                    dp[j][k] = Math.min(dp[j][k - cur] + 1, dp[j - 1][k]);
                } else if (k == cur - 1) {
                    dp[j][k] = 1;
                } else {
                    dp[j][k] = dp[j - 1][k];
                }
            }

        }

        for (int j = 0; j < dp.length; j++) {
            for (int k = 0; k < dp[j].length; k++) {
                if (max == -1) {
                    max = dp[j][dp[j].length - 1];
                } else {
                    max = Math.min(max, dp[j][dp[j].length - 1]);
                }
                //   System.out.print(dp[j][k] + " ");
            }
            // System.out.println();
        }
        return max;
    }

}
