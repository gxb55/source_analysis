package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/26  21:16
 * @description 2257
 * 2257. 统计网格图中没有被保卫的格子数 显示英文描述
 * 通过的用户数1606
 * 尝试过的用户数2110
 * 用户总通过次数1654
 * 用户总提交次数3943
 * 题目难度Medium
 * 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
 * <p>
 * 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
 * <p>
 * 请你返回空格子中，有多少个格子是 没被保卫 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * 输出：7
 * 解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
 * 总共有 7 个没有被保卫的格子，所以我们返回 7 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * 输出：4
 * 解释：上图中，没有被保卫的格子用绿色表示。
 * 总共有 4 个没有被保卫的格子，所以我们返回 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * 1 <= guards.length, walls.length <= 5 * 104
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * guards 和 walls 中所有位置 互不相同 。
 */
public class Solution2257 {
    public static void main(String[] args) {
        Solution2257 solution2257 = new Solution2257();
      /*  int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}}, walls = {{0, 1}, {2, 2}, {1, 4}};*/


      /*  int m = 3, n = 3;
        int[][] guards = {{1, 1}}, walls = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};  */

        int m = 8, n = 9;
        int[][] guards = {{5, 8}, {5, 5}, {4, 6}, {0, 5}, {6, 5}}, walls = {{4, 1}};
        int i = solution2257.countUnguarded(m, n, guards, walls);
        System.out.println(i);
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];
        for (int[] wall : walls) {
            arr[wall[0]][wall[1]] = 1;
        }
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            arr[x][y] = -5;
            for (int i = x + 1; i < m; i++) {
                if (arr[i][y] == 1 || arr[i][y] == -5) {
                    break;
                }
                arr[i][y] = -1;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (arr[i][y] == 1 || arr[i][y] == -5) {
                    break;
                }
                arr[i][y] = -1;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (arr[x][i] == 1 || arr[x][i] == -5) {
                    break;
                }
                arr[x][i] = -1;
            }
            for (int i = y + 1; i < n; i++) {
                if (arr[x][i] == 1 || arr[x][i] == -5) {
                    break;
                }
                arr[x][i] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
