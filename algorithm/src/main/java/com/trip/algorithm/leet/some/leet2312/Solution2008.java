package com.trip.algorithm.leet.some.leet2312;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2008 {
    public static void main(String[] args) {
       /* int n = 5;
        int[][] rides = {{2, 5, 4}, {1, 5, 1}};*/

       /* int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};*/

        int n = 10;
        int[][] rides = {{2, 3, 6}, {8, 9, 8}, {5, 9, 7}, {8, 9, 1}, {2, 9, 2}, {9, 10, 6}, {7, 10, 10}, {6, 7, 9}, {4, 9, 7}, {2, 3, 1}};
        Solution2008 solution2008 = new Solution2008();
        long l = solution2008.maxTaxiEarnings1(n, rides);
        System.out.println(l);
    }

    public long maxTaxiEarnings1(int n, int[][] rides) {
        List<int[]> collect = Arrays.stream(rides).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        }).collect(Collectors.toList());

        long[][] dp = new long[rides.length][2];
        for (int i = 0; i < collect.size(); i++) {
            int[] ride = collect.get(i);
            int begin = ride[0];
            int end = ride[1];
            int val = ride[2];
            if (i == 0) {
                dp[0][0] = end;
                dp[0][1] = (val + (end - begin));
            } else {
                int index = getIndex(dp, i-1, 0, begin);
                boolean flag = false;
                if(index>=0){
                    flag = true;
                    dp[i][0] = end;
                    dp[i][1] = (val + (end - begin)) + dp[index][1];
                }
                if (!flag) {
                    dp[i][0] = end;
                    dp[i][1] = (val + (end - begin));
                }
                if (dp[i][1] < dp[i - 1][1]) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1];
                }
            }
        }

        return dp[rides.length - 1][1];
    }

    private int getIndex(long[][] dp, int right, int left, int val) {
        while (left <= right) {
            int mid = left + (right - left);
            long l = dp[mid][0];
            if (l > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]> collect = Arrays.stream(rides).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());
        Map<Integer, Long> map = new HashMap<>();
        return process(0, collect, 1, n, map);
    }

    private long process(int index, List<int[]> rides, int cur, int n, Map<Integer, Long> map) {
        if (index >= rides.size()) {
            return 0;
        }
        int[] ride = rides.get(index);
        if (ride[1] > n) {
            return 0;
        }

        if (cur > ride[0]) {
            return process(index + 1, rides, cur, n, map);
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        int begin = ride[0];
        int end = ride[1];
        int val = ride[2];
        long p1 = process(index + 1, rides, end, n, map) + (val + (end - begin));
        long p2 = process(index + 1, rides, cur, n, map);
        long max = Math.max(p2, p1);
        map.put(index, max);
        return max;
    }
}
