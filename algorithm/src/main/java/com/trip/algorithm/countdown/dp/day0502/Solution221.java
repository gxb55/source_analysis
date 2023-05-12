package com.trip.algorithm.countdown.dp.day0502;

/**
 * @author xbguo
 * @createTime 2023年05月02日 19:50:00
 */
public class Solution221 {
    public static void main(String[] args) {
        // char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        /*char[][] matrix = {
                {'0', '0', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        };*/
        int i = maximalSquare(matrix);
        System.out.println(i);
    }

    public static int maximalSquare(char[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        if (x == 0 || y == 0) {
            return 1;
        }
        int[][] dp = new int[x][y];
        int max = 0;
        for (int i = 0; i < x; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < y; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    int val = dp[i - 1][j - 1];
                    for (; val >= 1; val--) {
                        if ((i - val) >= 0 && (j - val) >= 0) {
                            boolean flag = true;
                            for (int k = (i - val); k < i; k++) {
                                if (matrix[k][j] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            for (int k = (j - val); k < j && flag; k++) {
                                if (matrix[i][k] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                dp[i][j] = val + 1;
                                break;
                            }
                        }
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
