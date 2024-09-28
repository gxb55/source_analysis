package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;

public class Solution48 {
    public static void main(String[] args) {
       /* int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}; */

        int[][] arr = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        Arrays.stream(arr).forEach(x -> {
            System.out.println(Arrays.toString(x));
        });
        System.out.println();
        rotate(arr);
        Arrays.stream(arr).forEach(x -> {
            System.out.println(Arrays.toString(x));
        });
    }

    public static void rotate(int[][] matrix) {
        int l = matrix.length;
        int l1 = l / 2;
        for (int i = 0; i < l; i++) {
            if (i >= l1) {
                break;
            }
            int leftIndex = i;
            int rightIndex = l - i-1;
            for (int j = leftIndex; j < rightIndex; j++) {
                int a = i - 0;
                int b = j - 0;
                //左上角
                int v1 = matrix[i][j];
                //右上角
                int v2 = matrix[b][l - a - 1];
                // 右下角
                int v3 = matrix[l - a - 1][l - b - 1];
                // 左下角
                int v4 = matrix[l - b - 1][ a ];

                matrix[i][j] = v4;

                matrix[b][l - a - 1] = v1;

                matrix[l - a - 1][l - b - 1] = v2;

                matrix[l - b - 1][ a ] = v3;
                System.out.println(v1 + "_" + v2 + "_" + v3 + "_" + v4);
            }
            System.out.println("=========");
        }
    }
}
