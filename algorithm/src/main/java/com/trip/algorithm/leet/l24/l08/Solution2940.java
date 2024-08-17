package com.trip.algorithm.leet.l24.l08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2940 {
    public static void main(String[] args) {

       /* int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};*/
     int[] heights = {5,3,8,2,6,1,4,6};
        int[][] queries = {{0,7},{3,5},{5,2},{3,0},{1,6}};
        int[] ints = leftmostBuildingQueries(heights, queries);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] arr = new int[queries.length];
        Arrays.fill(arr, -1);
        List<int[]>[] dp = new List[heights.length];
        for (int i = 0; i < heights.length; i++) {
            dp[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            if (x == y || heights[y] > heights[x]) {
                arr[i] = y;
            } else {
                // 在y位置往后要找到一个大于heights[y]的数字
                dp[y].add(new int[]{i, heights[x]});
            }
        }
        // 从小到大
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < heights.length; i++) {
            int val = heights[i];
            // 要解决的下标，当前下标一定会比要解决的下标大，其次就看val就可以了
            while (!queue.isEmpty() && queue.peek()[1] < val) {
                int[] poll = queue.poll();
                arr[poll[0]] = i;

            }
            // 到当前下标的时候才会把要解决的放入，
            List<int[]> ints = dp[i];
            for (int[] t : ints) {
                queue.add(t);
            }
        }
        return arr;
    }
}
