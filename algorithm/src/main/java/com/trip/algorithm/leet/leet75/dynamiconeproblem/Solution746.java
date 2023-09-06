package com.trip.algorithm.leet.leet75.dynamiconeproblem;

/**
 * @author xbguo
 * @date 2023/9/6 16:52
 */
public class Solution746 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        int[] res = new int[cost.length + 1];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < res.length; i++) {
            res[i] = Math.min(res[i - 1], res[i - 2]) + (i >= cost.length ? 0 : cost[i]);
        }
        return res[res.length - 1];
    }
}
