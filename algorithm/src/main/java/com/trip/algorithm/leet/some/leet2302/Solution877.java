package com.trip.algorithm.leet.some.leet2302;


import com.trip.algorithm.leet.some.codeThink.Solution;

/**
 * @author xbguo
 * @date 2023/2/22 16:05
 */
public class Solution877 {
    public static void main(String[] args) {
        //  int[] piles = {5, 3, 4, 5};
        int[] piles = {3, 7, 2, 3};
        boolean b = Solution877.stoneGame(piles);
        System.out.println(b);
    }

    public static boolean stoneGame(int[] piles) {
        process(piles, 0, 0, 0, piles.length - 1, true);
        return success;
    }

    static boolean success = false;

    private static void process(int[] piles, int x, int y, int left, int right, boolean flag) {
        if(left>=piles.length||right<0){
            return;
        }
        if (left == right) {
            if (x > y) {
                success = true;
                return;
            }
        }
        if (flag) {
            process(piles, x + piles[left], y, left + 1, right, !flag);
            process(piles, x + piles[right], y, left, right - 1, !flag);

        } else {
            process(piles, x, y + piles[left], left + 1, right, !flag);
            process(piles, x, y + piles[right], left, right - 1, !flag);
        }

    }

    public boolean stoneGame1(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }


}
