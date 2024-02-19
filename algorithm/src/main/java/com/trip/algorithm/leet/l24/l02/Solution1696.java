package com.trip.algorithm.leet.l24.l02;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution1696 {
    public static void main(String[] args) {
        Solution1696 solution1696 = new Solution1696();
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        int i = solution1696.maxResult1(nums, k);
        System.out.println(i);
    }

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        LinkedList<Integer> list = new LinkedList<>();
        dp[0] = nums[0];
        list.add(0);
        for (int i = 1; i < len; i++) {
            // 前面下标不符合要求的全部丢弃
            while (list.peekFirst() < i - k) {
                list.pollFirst();
            }
            dp[i] = nums[i] + dp[list.peekFirst()];
            // list里面单调递减，单调栈
            while (!list.isEmpty() && dp[list.peekLast()] < dp[i]) {
                list.pollLast();
            }
            list.add(i);
        }
        return dp[len - 1];
    }

    public int maxResult1(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        PriorityQueue<int[]> list = new PriorityQueue<>((x, y) -> {
            return y[1] - x[1];
        });
        dp[0] = nums[0];
        list.add(new int[]{0, dp[0]});
        for (int i = 1; i < len; i++) {
            // 大顶堆，不符合要求的出去，永远保证第一个最大的且符合要求
            while (!list.isEmpty() && list.peek()[0] < i - k) {
                list.poll();
            }
            dp[i] = nums[i] + list.peek()[1];

            list.add(new int[]{i, dp[i]});
        }
        return dp[len - 1];
    }
}
