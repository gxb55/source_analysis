package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/28 18:42
 */
public class Solution57 {
    public static void main(String[] args) {
       /* int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5}; */

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] insert = insert(intervals, newInterval);
        for (int[] a:insert){
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> collect = Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        collect.add(newInterval);
        collect = collect.stream().sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        List<int[]> list = new ArrayList<>();
        int[] arr = null;
        for (int i = 0; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if (arr == null) {
                arr = ints;
            } else {
                if (ints[0] <= arr[1]) {
                    arr[1] = Math.max(arr[1], ints[1]);
                } else {
                    list.add(arr);
                    arr = ints;
                }
            }
        }
        list.add(arr);
        int len = list.size();
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            dp[i] = list.get(i);
        }
        return dp;
    }
}
