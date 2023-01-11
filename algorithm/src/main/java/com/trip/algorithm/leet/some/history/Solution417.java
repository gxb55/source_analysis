package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/27  15:50
 * @description 417
 * 417. 太平洋大西洋水流问题
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 * 通过次数44,613提交次数85,158
 */
public class Solution417 {
    public static void main(String[] args) {
        Solution417 solution417 = new Solution417();
        int[][] arr =
                {{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}};
        List<List<Integer>> list = solution417.pacificAtlantic(arr);
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int len = heights.length;
        int y = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();
        if(heights.length==0){
            return list;
        }
        boolean[][] left = new boolean[len][y];
        boolean[][] right = new boolean[len][y];
        for (int i = 0; i < len; i++) {
            dfs(i, 0, heights, left);
            dfs(i, y - 1, heights, right);
        }
        for (int i = 0; i < y; i++) {
            dfs(0, i, heights, left);
            dfs(len - 1, i, heights, right);
        }

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left[i].length; j++) {
                if (left[i][j] && right[i][j]) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(j);
                    list.add(list1);
                }
            }
        }
        return list;
    }

    private void dfs(int x, int y, int[][] heights, boolean[][] left) {
        System.out.println(x+":"+y);
        if (left[x][y]) {
            return;
        }
        left[x][y] = true;
        int cur = heights[x][y];
        if ((x - 1) >= 0 && !left[x - 1][y] && heights[x - 1][y] >= cur) {
            dfs(x - 1, y, heights, left);
        }
        if ((x + 1) < heights.length && !left[x + 1][y] && heights[x + 1][y] >= cur) {
            dfs(x + 1, y, heights, left);
        }
        if ((y - 1) >= 0 && !left[x][y - 1] && heights[x][y - 1] >= cur) {
            dfs(x, y - 1, heights, left);
        }
        if ((y + 1) < heights[0].length && !left[x][y+1] && heights[x][y+1] >= cur) {
            dfs(x, y+1, heights, left);
        }
    }
}
