package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @createTime 2023年07月03日 22:30:00
 */
public class Solution2212 {
    public static void main(String[] args) {

    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] dp = new int[aliceArrows.length];
        for (int i = 0; i < aliceArrows.length; i++) {
            int aliceArrow = aliceArrows[i];
            if (numArrows < aliceArrow) {
                dp[i] = -1;
            } else {
                dp[i] = aliceArrow + 1;
            }
        }
        return null;
    }
}
