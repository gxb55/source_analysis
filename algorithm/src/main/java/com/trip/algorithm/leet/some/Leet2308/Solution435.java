package com.trip.algorithm.leet.some.Leet2308;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/11 17:10
 */
public class Solution435 {
    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
       // int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
       // int[][] intervals = {{1, 2}, {1, 2}, {1, 2}, {1, 3}};
        //int[][] intervals =  {{1,100},{11,22},{1,11},{2,12}};
        int[][] intervals =  {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        int i = solution435.eraseOverlapIntervals(intervals);
        System.out.println(i);
        System.out.println(solution435.eraseOverlapIntervals1(intervals));
    }
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
                System.out.println(right);
            }
        }
        System.out.println("++++++++++");
        return n - ans;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // 降序，找到最先结束的，如果后面碰到重叠的，就去除后面的，因为后面的结束的更晚，
        List<int[]> list = Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1] ;
            }
        }).collect(Collectors.toList());

        int count = 1;
        int right = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int[] ints = list.get(i);
            if (ints[0]>=right) {
                count++;
                right = ints[1];
            }
        }
        return intervals.length-count ;
    }
}
