package com.trip.algorithm.leet.some.leet2302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年02月21日 22:17:00
 */
public class Solution1326 {
    public static void main(String[] args) {
       /* int n = 5;
        int[] ranges = {3, 4, 1, 1, 0, 0}; */

        int n = 35;
        int[] ranges = {1, 0, 4, 0, 4, 1, 4, 3, 1, 1, 1, 2, 1, 4, 0, 3, 0, 3, 0, 3, 0, 5, 3, 0, 0, 1, 2, 1, 2, 4, 3, 0, 1, 0, 5, 2};
      /*  int n = 7;
        int[] ranges = {1, 2, 1, 0, 2, 1, 0, 1};*/

       /* int n = 5;
        int[] ranges = {3, 0, 1, 1, 0, 0};*/


        int i = minTaps3(n, ranges);
        System.out.println(i);
        System.out.println("========");
        i = minTaps1(n, ranges);
        System.out.println(i);
    }

    public static int minTaps3(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            rightMost[start] = Math.max(rightMost[start], end);
        }
        System.out.println(Arrays.toString(rightMost));

        int last = 0, ret = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                //  System.out.println(i);
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    public static int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            int range = ranges[i];
            if (range == 0) {
                continue;
            }
            int begin = Math.max(0, i - range);
            int end = Math.min(n, i + range);
            list.add(new int[]{begin, end});
        }
        if (list.size() == 0) {
            return -1;
        }
        List<int[]> collect = list.stream().sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        int i = collect.get(0)[0];
        if (i != 0) {
            return -1;
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 0; j < collect.size(); j++) {
            int[] ints = collect.get(j);
            int begin = ints[0];
            if (dp[begin] == Integer.MAX_VALUE) {
                return -1;
            }
            for (int k = begin; k <= ints[1]; k++) {
                dp[k] = Math.min(dp[k], dp[begin] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public static int minTaps1(int n, int[] ranges) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            int range = ranges[i];
            if (range == 0) {
                continue;
            }
            int begin = Math.max(0, i - range);
            int end = Math.min(n, i + range);
            dp[begin] = Math.max(end, dp[begin]);
        }
        System.out.println(Arrays.toString(dp));
        int count = 0;
        int next = 0;
        int cur = 0;
        for (int i = 0; i < dp.length; i++) {
            next = Math.max(dp[i], next);
            if (next == -1) {
                return -1;
            }
            if (cur == i) {
                cur = next;
                count++;
            }
        }
        return count;
    }
}
