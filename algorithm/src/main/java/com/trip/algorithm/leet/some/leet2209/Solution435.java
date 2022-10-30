package com.trip.algorithm.leet.some.leet2209;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xbguo
 * @createTime 2022年09月05日 21:42:00
 */
public class Solution435 {
    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
         //int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
         int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        // int[][] intervals = { {1,2}, {1,2}, {1,2} };
        //int[][] intervals = {{1, 2}, {2, 3}};
        int i = solution435.eraseOverlapIntervals1(intervals);
        System.out.println(i);
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int right = intervals[0][1];
        int max = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                max++;
                right = intervals[i][1];
            }
        }
        return intervals.length - max;
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return len - max;
    }
}
