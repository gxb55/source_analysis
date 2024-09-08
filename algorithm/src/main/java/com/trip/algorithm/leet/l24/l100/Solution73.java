package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution73 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int v = matrix[i][j];
                if(v==0){
                    set.add(i + "_" + j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int v = matrix[i][j];
                if (v == 0 && set.contains(i + "_" + j)) {
                    fillZero(matrix, i, j);
                }

            }
        }
    }

    private static void fillZero(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }
}
