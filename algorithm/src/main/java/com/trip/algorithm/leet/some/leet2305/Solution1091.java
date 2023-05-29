package com.trip.algorithm.leet.some.leet2305;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/5/26 09:55
 */
public class Solution1091 {
    public static void main(String[] args) {
        //   int[][] grid = {{0,1},{1,0}};
         int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        // int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
      //  int[][] grid = {{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}};
        int i = shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] step = new int[8][2];
        step[0] = new int[]{-1, -1};
        step[1] = new int[]{-1, 0};
        step[2] = new int[]{-1, 1};
        step[3] = new int[]{0, -1};
        step[4] = new int[]{0, 1};
        step[5] = new int[]{1, -1};
        step[6] = new int[]{1, 0};
        step[7] = new int[]{1, 1};
        int x = grid.length;
        if (grid[0][0] != 0) {
            return -1;
        }
        int[][] dp = new int[x][x];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1000000);
        }
        dp[0][0] = 1;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0, 0});
        Set<String> set = new HashSet<>();
        while (!list.isEmpty()) {
            int[] ints = list.pollLast();
            set.add(ints[0] + "," + ints[1]);
            int i = ints[0];
            int j = ints[1];
            for (int[] t : step) {
                int x1 = t[0] + i;
                int y1 = t[1] + j;
                if (x1 >= 0 && x1 < x && y1 >= 0 && y1 < x&&grid[x1][y1]==0) {
                    dp[i][j] = Math.min(dp[i][j], dp[x1][y1] + 1);
                    if(set.add(x1+","+y1)){
                        list.addFirst(new int[]{x1,y1});
                    }
                }
            }
        }


        /*for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 0) {
                    for (int[] t : step) {
                        int x1 = t[0] + i;
                        int y1 = t[1] + j;
                        if (x1 >= 0 && x1 < x && y1 >= 0 && y1 < x) {
                            dp[i][j] = Math.min(dp[i][j], dp[x1][y1] + 1);
                        }
                    }
                }
            }
        }*/
        return dp[x - 1][x - 1] == 1000000 ? -1 : dp[x - 1][x - 1];
    }
}
