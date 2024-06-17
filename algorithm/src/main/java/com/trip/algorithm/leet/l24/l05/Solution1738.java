package com.trip.algorithm.leet.l24.l05;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

public class Solution1738 {
    public static void main(String[] args) {
        /*int[][] matrix = {{5,2},{1,6}};
        int k=2; */

        int[][] matrix = {{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
        int k=10;
        int i = kthLargestValue(matrix, k);
        System.out.println(i);
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        queue.add(new int[]{dp[0][0],0,0});
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
            queue.add(new int[]{dp[i][0],i,0});
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
            queue.add(new int[]{dp[0][i],0,i});
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v=dp[i-1][j-1]^ matrix[i][j];
               // v=v^dp[i][j-1]^dp[i-1][j];
                for (int l = 0; l < i; l++) {
                    v=v^matrix[l][j];
                }
                for (int l = 0; l < j; l++) {
                    v=v^matrix[i][l];
                }
                dp[i][j] =v;
                queue.add(new int[]{v,i,j});
            }
        }
        while (k>1){
            int[] poll = queue.poll();
            System.out.println(JSON.toJSONString(poll));
            k--;
        }
        return queue.poll()[0];
    }
}
