package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1235 {
    public static void main(String[] args) {

        //  int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
        // int[] startTime = {1,1,1}, endTime = {2,3,4}, profit = {5,6,4};
        int[] startTime = {4, 2, 4, 8, 2}, endTime = {5, 5, 5, 10, 8}, profit = {1, 2, 8, 10, 4};
        int i = jobScheduling1(startTime, endTime, profit);
        System.out.println(i);
       // System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < startTime.length; i++) {
            int x = startTime[i];
            int y = endTime[i];
            int z = profit[i];
            list.add(new int[]{x, y, z, z});
        }
        list.sort((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            if (i == 0) {
                ints[3] = ints[2];
            } else {
                int begin = ints[0];

                int[] arr = findLeft(list, 0, i - 1, begin);
                if (arr != null) {
                    ints[3] = Math.max(ints[3], ints[2] + arr[3]);
                }
                ints[3] = Math.max(ints[3], list.get(i - 1)[3]);
            }
            max = Math.max(max, ints[3]);
        }
        return max;
    }

    private static int[] findLeft(List<int[]> list, int left, int right, int begin) {
        int[] res = null;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] ints = list.get(mid);
            if (ints[1] <= begin) {
                res = ints;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            int x = startTime[i];
            int y = endTime[i];
            int z = profit[i];
            List<int[]> orDefault = map.getOrDefault(y, new ArrayList<>());
            orDefault.add(new int[]{x, y, z});
            map.put(y, orDefault);
            max = Math.max(max, y);
        }
        int[] dp = new int[max + 1];
        for (int i = 1; i < dp.length; i++) {
            List<int[]> orDefault = map.get(i);
            if (orDefault == null) {
                dp[i] = dp[i - 1];
                continue;
            }
            for (int[] arr : orDefault) {
                dp[i] = Math.max(dp[i], dp[arr[0]] + arr[2]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
