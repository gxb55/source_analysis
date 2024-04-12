package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/12 15:57
 */
public class Solution2923 {
    public static void main(String[] args) {

    }

    /**
     * 0 <= i, j <= n - 1
     *
     * @param grid
     * @return
     */
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            boolean flag = true;
            for (int j = 0; j < grid.length; j++) {
                if (i == j) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    flag = false;
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
