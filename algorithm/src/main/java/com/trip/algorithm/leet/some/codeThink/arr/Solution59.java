package com.trip.algorithm.leet.some.codeThink.arr;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年11月01日 21:39:00
 */
public class Solution59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int t = 5;
        int[][] ints = solution59.generateMatrix(t);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int len = n;
        int l = 0;
        int r = len - 1;
        int t = 0;
        int b = len - 1;
        int val = 1;
        int res = n * n;
        while (val <= res) {
            for (int k = l; k <= r && val <= res; k++) {
                arr[t][k] = val;
                val++;
            }
            t++;
            for (int k = t; k <= b && val <= res; k++) {
                arr[k][r] = val;
                val++;
            }
            r--;

            for (int i = r; i >= l && val <= res; i--) {
                arr[b][i] = val;
                val++;
            }
            b--;
            for (int i = b; i >= t && val <= res; i--) {
                arr[i][l] = val;
                val++;
            }
            l++;
        }
        return arr;
    }

    public int[][] generateMatrix1(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

}
