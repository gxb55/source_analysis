package com.trip.algorithm.leet.l24.l06;

import java.util.LinkedList;

public class Solution2742 {
    public static void main(String[] args) {
        // int[] cost = {1,2,3,2}, time = {1,2,3,2};
        // int[] cost = {26, 53, 10, 24, 25, 20, 63, 51}, time = {1, 1, 1, 1, 2, 2, 2, 1};
        int[] cost = {42, 8, 28, 35, 21, 13, 21, 35}, time = {2, 1, 1, 1, 2, 1, 1, 2};
        int i = paintWalls1(cost, time);
        System.out.println(i);
    }

    public static int paintWalls(int[] cost, int[] time) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < cost.length; i++) {
            list.add(new int[]{cost[i], time[i]});
        }
        // 免费的从后往前，付费的从前往后
        list.sort((x, y) -> {
            double a = (x[0] * 1.0) / x[1];
            double b = (y[0] * 1.0) / y[1];
            return a >= b ? 1 : -1;
           /* if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }*/
        });
        int res = 0;
        int p1 = 0;
        while (!list.isEmpty()) {
            if (p1 == 0) {
                int[] ints = list.pollFirst();
                p1 += ints[1];
                res += ints[0];
            }
            if (p1 > 0) {
                int[] ints = list.pollLast();
                p1 -= 1;
            }
        }
        return res;
    }

    public static int paintWalls1(int[] cost, int[] time) {
        int length = cost.length;
        // x是下标，y是时间 dp[x][y]是cost
        int[][] dp = new int[length][2501];
        dp[0][time[0]] = cost[0];
        for (int i = 1; i < dp.length; i++) {
            int val = cost[i];
            int t = time[i];
            if (dp[i][t] != 0) {
                dp[i][t] = Math.min(val, dp[i][t]);
            } else {
                dp[i][t] = val;
            }
            for (int j = 0; j < dp[i].length; j++) {
                if ((j - t) >= 0 && dp[i - 1][j - t] != 0) {
                    if (dp[i][j] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - t] + val, dp[i][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j - t] + val;
                    }
                }
            }
        }
        int sum = 0;
        for (int x : time) {
            sum += x;
        }
        int a = sum / 2 + (sum % 2 == 0 ? 0 : 1);
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = a-1; j < dp[i].length; j++) {
                int v = dp[i][j];
                if (v != 0) {
                    if (res == 0) {
                        res = v;
                    } else {
                        res = Math.min(res, v);
                    }
                }
            }
        }
        return res;

    }
}
