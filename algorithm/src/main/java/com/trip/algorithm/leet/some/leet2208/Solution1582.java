package com.trip.algorithm.leet.some.leet2208;

/**
 * @author xbguo
 * @createTime 2022年09月04日 20:28:00
 * 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 * 通过次数32,162提交次数46,449
 */
public class Solution1582 {
    public static void main(String[] args) {
        Solution1582 solution1582 = new Solution1582();
      /*  int[][] mat = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };*/
       /* int[][] mat = {{1,0,0},
                {0,1,0},
                {0,0,1}};*/
        int[][] mat = {{0,0,0,0,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}};

      /*  int[][] mat = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
        };*/
        int i = solution1582.numSpecial(mat);
        System.out.println(i);
    }

    public int numSpecial(int[][] mat) {
        int[] arrX = new int[mat.length];
        int[] arrY = new int[mat[0].length];
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if ((mat[i][j] == 1) && check(mat, i, arrX, j, arrY)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[][] mat, int i, int[] arrX, int j, int[] arrY) {
        boolean x = true;
        boolean y = true;
        int xLen = mat.length;
        int yLen = mat[0].length;
        if (arrX[i] == 0) {
            int[] ints = mat[i];
            for (int k = 0; k < yLen; k++) {
                if (k == j) {
                    continue;
                }
                if (ints[k] == 1) {
                    x = false;
                    arrX[i] = 10;
                }
            }
        } else if (arrX[i] == 10) {
            x = false;
        }
        if (!x) {
            return x;
        }

        arrX[i] = 5;
        if (arrY[j] == 0) {
            for (int k = 0; k < xLen; k++) {
                if (k == i) {
                    continue;
                }
                if (mat[k][j] == 1) {
                    y = false;
                    arrY[j] = 10;
                }
            }
        } else if (arrY[j] == 10) {
            y = false;
        }
        if (y) {
            arrY[j] = 5;
        }
        return x && y;
    }


}
