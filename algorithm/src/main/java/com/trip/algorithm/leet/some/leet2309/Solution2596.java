package com.trip.algorithm.leet.some.leet2309;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xbguo
 * @date 2023/9/13 14:02
 * ，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 */
public class Solution2596 {
    public static void main(String[] args) {
        Solution2596 solution2596 =new Solution2596();
       // int[][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
      //  int[][] grid = {{0,3,6},{5,8,1},{2,7,4}};
       // int[][] grid = {{8,3,6},{5,0,1},{2,7,4}};
        int[][] grid = {
                {24,11,22,17,4},
                {21,16,5,12,9},
                {6,23,10,3,18},
                {15,20,1,8,13},
                {0,7,14,19,2}
        };
        boolean b = solution2596.checkValidGrid(grid);
        System.out.println(b);
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int curX = 0;
        int curY = 0;
        int curVal = 0;
        int[][] arr = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}};
        while (true) {
            System.out.println(curVal);
            List<int[]> list = new ArrayList<>();
            for (int[] t : arr) {
                int x = t[0];
                int y = t[1];
                int nextX = curX + x;
                int nextY = curY + y;
                if (nextY >= 0 && nextX >= 0 && nextX < n && nextY < n) {
                    list.add(new int[]{nextX, nextY});
                }
            }
            int finalCurVal = curVal;
            Optional<int[]> first = list.stream().filter(z -> grid[z[0]][z[1]] == finalCurVal + 1).findFirst();
            if (first.isPresent()) {
                int[] z = first.get();
                curVal = grid[z[0]][z[1]];
                curX = z[0];
                curY = z[1];
            } else {
                break ;
            }
        }
        int t = (n * n) - 1;
        boolean b = curVal ==t ;
        return b;
    }

}
