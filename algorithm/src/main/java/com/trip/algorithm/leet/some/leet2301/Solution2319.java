package com.trip.algorithm.leet.some.leet2301;

/**
 * @author xbguo
 * @date 2023/1/31 09:38
 * @description 2319
 * 2319. 判断矩阵是否是一个 X 矩阵
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 *
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
 * 输出：true
 * 解释：矩阵如上图所示。
 * X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
 * 因此，grid 是一个 X 矩阵。
 * 示例 2：
 *
 *
 * 输入：grid = [[5,7,0],[0,3,1],[0,5,0]]
 * 输出：false
 * 解释：矩阵如上图所示。
 * X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
 * 因此，grid 不是一个 X 矩阵。
 *
 *
 * 提示：
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 0 <= grid[i][j] <= 105
 * 通过次数15,045提交次数19,829
 */
public class Solution2319 {
    public static void main(String[] args) {
        Solution2319 solution2319 = new Solution2319();
        int[][] grid = {
                {2,0,0,1},
                {0,3,1,0},
                {0,5,2,0},
                {4,0,0,2}};
        boolean b = solution2319.checkXMatrix(grid);
        System.out.println(b);
    }

    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        // 对角线
        int i = 0;
        int j = 0;
        while (i < len) {
            int val = grid[i][j];
            if (val == 0) {
                return false;
            }
            grid[i][j] = -1;
            i++;
            j++;
        }
        i = 0;
        j = len - 1;
        while (i < len) {
            int val = grid[i][j];
            if (val == 0) {
                return false;
            }
            grid[i][j] = -1;
            i++;
            j--;
        }
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                int val = grid[k][l];
                if (val <= 0) {
                } else if (val != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
