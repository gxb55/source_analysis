package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author xbguo
 * @createTime 2022年06月26日 17:22:00
 * 1706. 球会落何处
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * 示例 2：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * 输出：[0,1,2,3,4,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 * 通过次数32,379提交次数46,757
 */
public class Solution1706 {
    public static void main(String[] args) {
      //  int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
       // int[][] grid = {{-1}};
        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        Solution1706 solution1706 = new Solution1706();
        int[] ball = solution1706.findBall(grid);
        System.out.println(Arrays.toString(ball));
    }

    int lenx;
    int leny;

    public int[] findBall(int[][] grid) {
        lenx = grid.length;
        leny = grid[0].length;

        int[] resArr = new int[leny];
        for (int i = 0; i < leny; i++) {
            int res = process(0, i, grid, "T");
            resArr[i] = res;
        }
        return resArr;
    }

    private int process(int x, int y, int[][] grid, String from) {

        int val = grid[x][y];
        if (Objects.equals(from, "T")) {
            if (val == 1 && (y + 1) < leny && grid[x][y + 1] == val) {
                return process(x, y + 1, grid, "L");
            } else if (val == -1 && (y - 1) >= 0 && grid[x][y - 1] == val) {
                return process(x, y - 1, grid, "R");
            } else {
                return -1;
            }
        } else if (Objects.equals(from, "L") || Objects.equals(from, "R")) {
            if ((x + 1) < lenx) {
                return process(x + 1, y, grid, "T");
            } else if ((x + 1) == lenx) {
                return y;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
