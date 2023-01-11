package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/24  21:44
 * @description 980. 不同路径 III
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 * <p>
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 */
public class Solution980 {
    public static void main(String[] args) {
        Solution980 solution980 = new Solution980();
        //int[][] arr = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][] arr = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int i = solution980.uniquePathsIII(arr);
        System.out.println(i);
    }

    int[] begin = new int[2];
    int[] end = new int[2];
    int t = 0;
    int len1;
    int len2;
    boolean[][] flags;

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    begin = new int[]{i, j};
                } else if (val == 2) {
                    end = new int[]{i, j};
                } else if (val != -1) {
                    t++;
                }
            }
        }
        len1 = grid.length;
        len2 = grid[0].length;
        flags = new boolean[len1][len2];
        flags[begin[0]][begin[1]] = true;
        int cur = 0;
        return process(grid, begin[0], begin[1], cur);
    }

    private int process(int[][] grid, int x, int y, int cur) {
        if (grid[x][y] == -1) {
            return 0;
        }

        if (x == end[0] && y == end[1]) {
            System.out.println("=============");
            for (boolean[] arr : flags) {
                for (boolean t : arr) {
                    System.out.print(t + "  ");
                }
                System.out.println();
            }

            if (cur == t + 1) {
                return 1;
            }
        }
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        if ((x - 1) >= 0 && !flags[x - 1][y]) {
            flags[x - 1][y] = true;
            p1 = process(grid, x - 1, y, cur + 1);
            flags[x - 1][y] = false;
        }
        if ((x + 1) < len1 && !flags[x + 1][y]) {
            flags[x + 1][y] = true;
            p2 = process(grid, x + 1, y, cur + 1);
            flags[x + 1][y] = false;
        }
        if ((y - 1) >= 0 && !flags[x][y - 1]) {
            flags[x][y - 1] = true;
            p3 = process(grid, x, y - 1, cur + 1);
            flags[x][y - 1] = false;
        }
        if ((y + 1) < len2 && !flags[x][y + 1]) {
            flags[x][y + 1] = true;
            p4 = process(grid, x, y + 1, cur + 1);
            flags[x][y + 1] = false;
        }
        return p1 + p2 + p3 + p4;
    }
}
