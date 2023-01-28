package com.trip.algorithm.leet.some.leet2301;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/1/25 11:53
 */
public class Solution1828 {
    public static void main(String[] args) {
        double sqrt = Math.sqrt(4);
        // System.out.println(sqrt);
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}}, queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        Solution1828 solution1828 = new Solution1828();
        int[] ints = solution1828.countPoints(points, queries);
        System.out.println(Arrays.toString(ints));

    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int cur;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            cur = 0;
            for (int j = 0; j < points.length; j++) {
                int i1 = points[j][1] - query[1];
                int i2 = points[j][0] - query[0];
                int x = i1 * i1 + i2 * i2;
                double sqrt = Math.sqrt(x);
                if (query[2] >= sqrt) {
                    cur++;
                }
            }
            res[i] = cur;
        }
        return res;
    }
}
