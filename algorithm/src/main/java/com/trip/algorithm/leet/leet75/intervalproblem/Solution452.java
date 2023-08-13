package com.trip.algorithm.leet.leet75.intervalproblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xbguo
 * @createTime 2023年08月12日 09:18:00
 */
public class Solution452 {
    public static void main(String[] args) {
        Solution452 solution452 = new Solution452();
        // int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        //int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int minArrowShots = solution452.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    public int findMinArrowShots(int[][] points) {


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long l1 = Long.valueOf(o1[1]);
                long l2 = Long.valueOf(o2[1]);
                // 按照右端点降序
                return (l1-l2)>=0?1:-1 ;
            }
        });
        int count = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] <= right) {

            } else {
                count++;
                right = point[1];
            }
        }
        return count;
    }
}
