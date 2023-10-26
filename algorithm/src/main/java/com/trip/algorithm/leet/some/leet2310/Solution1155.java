package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/24 09:41
 */
public class Solution1155 {
    public static void main(String[] args) {
        Solution1155 solution1155 = new Solution1155();
        //  int n = 1, k = 6, target = 3;
        //  int n = 2, k = 6, target = 7;
        int n = 30, k = 30, target = 500;
        int i = solution1155.numRollsToTarget1(n, k, target);
        System.out.println(i);
    }

    public int numRollsToTarget1(int n, int k, int target) {
        // 到n个色子的时候和是target
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {
                for (int l = 1; l <= k && j >= l; l++) {
                    dp[i][j] = (dp[i - 1][j - l] + dp[i][j]) % 1000000007;
                }
            }
        }
        return dp[n][target];
    }

    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        this.target = target;
        process(0, 0);
        return total;
    }

    int n;
    int k;
    int target;
    Integer total = 0;

    private void process(int index, int sum) {
        int val = (target - sum) / ((n - index) == 0 ? 1 : n - index);
        if (val > k) {
            return;
        }
        if (index == n && sum == target) {
            total += 1;
            total = total % 1000000007;
            return;
        }
        if (index >= n) {
            return;
        }
        for (int i = 1; i <= k; i++) {
            process(index + 1, sum + i);
        }
    }


}
