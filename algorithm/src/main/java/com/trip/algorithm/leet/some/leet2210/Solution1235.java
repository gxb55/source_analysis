package com.trip.algorithm.leet.some.leet2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年10月23日 11:00:00
 */
public class Solution1235 {
    public static void main(String[] args) {
        Solution1235 solution1235 = new Solution1235();
        //  int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
        //int[] startTime = {1,2,3,4,6}, endTime = {3,5,10,6,9}, profit = {20,20,100,70,60};
        //  int[] startTime = {1, 1, 1}, endTime = {2, 3, 4}, profit = {5, 6, 4};
        // int[] startTime = {6, 15, 7, 11, 1, 3, 16, 2}, endTime = {19, 18, 19, 16, 10, 8, 19, 8}, profit = {2, 9, 1, 19, 5, 7, 3, 19};
        //{24,24,7,2,1,13,6,14,18,24}
        //{27,27,20,7,14,22,20,24,19,27}
        //{6,1,4,2,3,6,5,6,9,8}
        //  int[] startTime = {24, 24, 7, 2, 1, 13, 6, 14, 18, 24}, endTime = {27, 27, 20, 7, 14, 22, 20, 24, 19, 27}, profit = {6, 1, 4, 2, 3, 6, 5, 6, 9, 8};
        int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};

        int i = solution1235.jobScheduling2(startTime, endTime, profit);
        int t = solution1235.jobScheduling1(startTime, endTime, profit);
        System.out.println(i);
        System.out.println(t);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] arr = new int[len][3];
        for (int i = 0; i < len; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        List<int[]> collect = Arrays.stream(arr).sorted((x, y) -> x[1] - y[1]).collect(Collectors.toList());
        for (int i = 0; i < len; i++) {
            int[] ints = collect.get(i);
            startTime[i] = ints[0];
            endTime[i] = ints[1];
            profit[i] = ints[2];
        }

        int[][] dp = new int[len][2];
        int cur0 = 0;
        int cur1 = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = profit[i];
                cur1 = endTime[i];
            } else {
                int x = cur0;
                int i1 = startTime[i];
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
                if (dp[i - 1][1] > dp[i - 1][0]) {
                    cur0 = cur1;
                } else if (dp[i - 1][1] == dp[i - 1][0]) {
                    cur0 = Math.min(cur1, cur0);
                }

                if (cur1 > i1 && x > i1) {
                    dp[i][1] = profit[i];
                } else if (cur1 <= i1 && x <= i1) {
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + profit[i];
                } else if (cur1 > i1 && x <= i1) {
                    dp[i][1] = dp[i - 1][0] + profit[i];
                } else if (cur1 <= i1 && x > i1) {
                    dp[i][1] = dp[i - 1][1] + profit[i];
                }
                cur1 = endTime[i];
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] arr = new int[len][3];
        for (int i = 0; i < len; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        List<int[]> collect = Arrays.stream(arr).sorted((x, y) -> x[1] - y[1]).collect(Collectors.toList());
        for (int i = 0; i < len; i++) {
            int[] ints = collect.get(i);
            startTime[i] = ints[0];
            endTime[i] = ints[1];
            profit[i] = ints[2];
        }
        /**
         * 1.用我们上一个值的
         * 2.用我当前值的
         * 3.用我当前的+之前符合要求的res
         */
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[i] = profit[i];
            } else {
                res[i] = Math.max(res[i - 1], profit[i]);
                int begin = startTime[i];
                int l = 0;
                int r = i - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    int end = endTime[mid];
                    if (begin >= end) {
                        l = mid ;
                    } else {
                        r = mid - 1;
                    }
                }

                if (endTime[r] <= begin) {
                    res[i] = Math.max(res[i], profit[i] + res[r]);
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res[len - 1];
    }

    public int jobScheduling2(int[] st, int[] et, int[] ps) {
        int n = st.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new int[]{st[i], et[i], ps[i]});
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            int[] info = list.get(i - 1);
            int a = info[0], b = info[1], c = info[2];
            f[i] = Math.max(f[i - 1], c);
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid)[1] <= a) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(r)[1] <= a) {
                f[i] = Math.max(f[i], f[r + 1] + c);
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

}
