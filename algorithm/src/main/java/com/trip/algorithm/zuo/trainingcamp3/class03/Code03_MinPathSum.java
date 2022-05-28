package com.trip.algorithm.zuo.trainingcamp3.class03;

/**
 * 给定一个二维数组matrix，其中每个数都是正数，要求从左上到右下
 * 每一步只能向右或者向下，沿途经过的数字要累加起来
 * 最后请返回最小的路径和
 * <p>
 * 动态规划的空间压缩技巧！
 */
public class Code03_MinPathSum {
    public static void main(String[] args) {
        int[][] m = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println(minPathSum1(m));
        System.out.println(minPathSum_Teacher(m));
    }

    public static int minPathSum1(int[][] m) {
        int i = m.length;
        int j = m[0].length;
        int[][] arr = new int[i][j];
        arr[0][0]=m[0][0];
        for (int k = 1; k < i; k++) {
            arr[k][0] = m[k][0]+m[k-1][0];
        }
        for (int k = 1; k < j; k++) {
            arr[0][k] = m[0][k]+m[0][k-1];
        }
        for (int k = 1; k < i; k++) {
            for (int l = 1; l < j; l++) {
                arr[k][l] = Math.min(arr[k - 1][l], arr[k][l - 1]) + m[k][l];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < j; k++) {
            min = Math.min(arr[i - 1][k], min);
        }
        return min;
    }
    public static int minPathSum_Teacher(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
