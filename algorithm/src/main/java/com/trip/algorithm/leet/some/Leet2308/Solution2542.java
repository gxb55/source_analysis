package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/8/11 10:45
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
 * <p>
 * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
 * <p>
 * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
 * 用公示表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
 * 请你返回 最大 可能的分数。
 * <p>
 * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
 */
public class Solution2542 {
    public static void main(String[] args) {
        Solution2542 s = new Solution2542();
       /* int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3; */

        int[] nums1 = {2,1,14,12};
        int[] nums2 = {11,7,13,6};
        int k = 3;


        long l = s.maxScore1(nums1, nums2, k);
        System.out.println(l);
    }

    public long maxScore1(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            dp[i][0] = nums1[i];
            dp[i][1] = nums2[i];
        }
        // 按照 nums2降序排列
        Arrays.sort(dp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        long sum = 0;
        long res = 0;
        int min = 0;
        for (int i = 0; i < len; i++) {
            sum=sum+ dp[i][0];
            min = dp[i][1];
            priorityQueue.add(dp[i][0]);
            if (i + 1 >= k) {
                long v = sum * min;
                res = Math.max(res, v);
                Integer poll = priorityQueue.poll();
                sum -= poll;
            }
        }
        return res;
    }


    public long maxScore(int[] nums1, int[] nums2, int k) {
        long maximumScore = 0;
        int n = nums1.length;
        int[][] nums2D = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums2D[i][0] = nums1[i];
            nums2D[i][1] = nums2[i];
        }
        // 降序排列
        Arrays.sort(nums2D, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long sum = 0;
        long minimum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                int prev = pq.poll();
                sum -= prev;
            }
            int[] arr = nums2D[i];
            pq.offer(arr[0]);
            sum += arr[0];
            minimum = arr[1];
            if (i >= k - 1) {
                long currScore = sum * minimum;
                maximumScore = Math.max(maximumScore, currScore);
            }
        }
        return maximumScore;
    }


}
