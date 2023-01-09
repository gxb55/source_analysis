package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/26  11:16
 * @description 883
 * 883. 三维形体投影面积
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * <p>
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * <p>
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * <p>
 * 返回 所有三个投影的总面积 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * 示例 2:
 * <p>
 * 输入：grid = [[2]]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * 通过次数21,563提交次数28,981
 */
public class Solution883 {
    public static void main(String[] args) {
        Solution883 solution883 = new Solution883();
        //  int[][] arr = {{1, 2}, {3, 4}};
        // int[][] arr = {{2}};
        //int[][] arr = {{1, 0}, {0, 2}};
        int[][] arr = {{2, 3}, {2, 4}};
        int i = solution883.projectionArea(arr);
        System.out.println(i);
    }

    public int projectionArea(int[][] grid) {
        int x = 0;
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int max = -1;
            int max1 = -1;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    x++;
                }
                max = Math.max(max, grid[i][j]);
            }
            for (int j = 0; j < grid[i].length; j++) {
                max1 = Math.max(max1, grid[j][i]);
            }
            listX.add(max);
            listY.add(max1);
        }
        int res = x;
        for (int a : listX) {
            res += a;
        }
        for (int a : listY) {
            res += a;
        }
        return res;
    }
}
