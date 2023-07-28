package com.trip.algorithm.leet.some.leet2307;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/7/13 10:44
 */
public class Solution931 {
    public static void main(String[] args) {
        Solution931 solution931 = new Solution931();
        //int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        // int[][] matrix = {{-19,57},{-40,-5}};
      /*  int[][] matrix = {
                {100, -42, -46, -41},
                {31, 97, 10, -10},
                {-58, -51, 82, 89},
                {51, 81, 69, -51}
        }; */

        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0}

        };

        int i = solution931.minFallingPathSum6(matrix);
        System.out.println(i);
    }
    public int minFallingPathSum6(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == matrix.length - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j + 1], matrix[i - 1][j - 1]));
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            res=Math.min(res,matrix[matrix.length-1][i]);
        }
        return res;
    }













    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length, res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
                }
            }
        }
        for (int j = 0; j < n; j++) {
            res = Math.min(res, matrix[n - 1][j]);
        }
        return res;
    }


    int res = Integer.MAX_VALUE;

    private void process(int val, int x, int y) {
        if ((x + 1) >= matrix.length) {
            res = Math.min(res, val);
            return;
        }
        process(val + matrix[x + 1][y], x + 1, y);

        if ((y - 1) >= 0) {
            process(val + matrix[x + 1][y - 1], x + 1, y - 1);
        }
        if ((y + 1) < matrix.length) {
            process(val + matrix[x + 1][y + 1], x + 1, y + 1);
        }
    }

    public int minFallingPathSum(int[][] matrix) {
        int t = Integer.MAX_VALUE;
        this.matrix = matrix;
        this.dp = new int[matrix.length][matrix.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int i = 0;
        for ( ;i < matrix.length; i++) {
            boolean b = Arrays.stream(matrix[i]).allMatch(x -> x == 0);
            if(!b){
               break;
            }
        }
        int j=matrix.length-1;
        for ( ;j>=0; j--) {
            boolean b = Arrays.stream(matrix[j]).allMatch(x -> x == 0);
            if(!b){
                break;
            }
        }
        this.matrix =new int[j-i+1][matrix.length];
        int index=0;
        for (int k = i; k <= j; k++) {
            this.matrix[index]=matrix[k];
            index++;
        }
         i = 0;
        for ( ;i < this.matrix[0].length; i++) {
            int i1 = process1(0, i) + this.matrix[0][i];
            t = Math.min(t, i1);
        }
        return t;
    }

    int[][] matrix;
    int[][] dp;

    private int process1(int x, int y) {
        if ((x + 1) >= matrix.length) {
            return 0;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int p1 = process1(x + 1, y) + matrix[x + 1][y];
        int p2 = Integer.MAX_VALUE;
        int p3 = Integer.MAX_VALUE;
        if ((y - 1) >= 0) {
            p2 = process1(x + 1, y - 1) + matrix[x + 1][y - 1];
        }
        if ((y + 1) < matrix.length) {
            p3 = process1(x + 1, y + 1) + matrix[x + 1][y + 1];
        }
        int res = Math.min(p2, p3);
        res = Math.min(p1, res);
        dp[x][y] = res;
        return res;
    }

}
