package com.trip.algorithm.leet.some.leet2307;

/**
 * @author xbguo
 * @createTime 2023年07月22日 10:13:00
 */
public class Solution860 {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int[] dp = new int[3];
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                dp[0]++;
            } else if (bill == 10) {
                if (dp[0] < 1) {
                    return false;
                }
                dp[0]--;
                dp[1]++;
            } else {
                if (dp[0] >= 1 && dp[1] >= 1) {
                    dp[0]--;
                    dp[1]--;
                    dp[2]++;
                } else if (dp[0] >= 3) {
                    dp[0] -= 3;
                    dp[2]++;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
