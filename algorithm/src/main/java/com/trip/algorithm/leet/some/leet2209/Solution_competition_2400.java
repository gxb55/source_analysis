package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月17日 11:38:00
 */
public class Solution_competition_2400 {
    public static void main(String[] args) {
        Solution_competition_2400 solution = new Solution_competition_2400();
        //int startPos = 1, endPos = 2, k = 3;
        // int startPos = 2, endPos = 5, k = 10;
        int startPos = 272, endPos = 270, k = 6;
        int i = solution.numberOfWays(startPos, endPos, k);
        System.out.println(i);
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int l=startPos;
        int r=endPos;
        startPos = Math.min(l, r);
        endPos = Math.max(l, r);

        int len = endPos - startPos;
        if (k < len) {
            return 0;
        }
        int res = 0;
        int i = 0;
        while (true) {
            int t = k - (i * 2 * len + len);
            if (t < 0) {
                break;
            }
            if (t == 0) {
                res++;
            } else if (t % 2 == 0) {
                res += 2;
            }
            res = res % (1000000000 + 7);
            i++;
        }
        return res;
    }
    long MOD = 1000000007L;
    public int numberOfWays1(int startPos, int endPos, int k) {
        /**
         * 因为是无限数轴，所以是可以一直往左移动的，要考虑负数，再考虑 k 的范围
         * 先定义 dp 数组为 dp[i + 1000][j] 表示到达位置 i，花费 j 步的方案数。
         * 状态转移方程为 dp[i + 1000][j] = dp[i - 1 + 1000][j - 1] + dp[i + 1 + 1000][j - 1]
         * 其中 dp[i - 1 + 1000][j - 1] 表示已经走了 j - 1 步，下一步可以从 i - 1 位置可以走到 i 位置
         * dp[i + 1 + 1000][j - 1] 表示已经走了 j - 1 步，下一步可以从 i + 1 位置走到 i 位置
         */
        long[][] dp = new long[3002][1001];
        /**
         * 初始化 dp 数组，因为从任意位置走 0 步无法到达任意位置，所以 dp[...][0] 均为 0
         * 从初始位置走一步可以到达的位置是 i - 1 或 i + 1，初始化只有一种方案;
         */
        dp[startPos + 1 + 1000][1] = 1;
        dp[startPos - 1 + 1000][1] = 1;
        /**
         * 开始进行状态转移
         */
        for (int j = 2; j <= k; j++) {
            /**
             * 最左可到达的位置为 startPos - k，最右可到达的位置为 startPos + k，所以在这个范围进行状态转移
             * 计算从 i - 1 到 i 和从 i + 1 到 i 可能的方案数
             */
            for (int i = 1000 + startPos - k; i <= 1000 + startPos + k; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i + 1][j - 1];
                dp[i][j] %= MOD;
            }
        }
        /**
         * 返回 dp 数组中能够 k 步到达 endPos 的方案数即可
         */
        return (int) dp[1000 + endPos][k];
    }


}
