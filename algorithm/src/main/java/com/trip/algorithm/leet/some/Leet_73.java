package com.trip.algorithm.leet.some;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年04月30日 22:46:00
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class Leet_73 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        Leet_73 leet_73 = new Leet_73();
        leet_73.setZeroes(arr);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    vis[i][j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (vis[i][j]) {
                    setZero(matrix, i, j);
                }
            }
        }

    }

    private void setZero(int[][] matrix, int i, int j) {
        int x = matrix.length;
        int y = matrix[0].length;
        for (int k = 0; k < y; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < x; k++) {
            matrix[k][j] = 0;
        }


    }

}
