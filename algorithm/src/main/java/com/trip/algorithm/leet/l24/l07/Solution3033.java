package com.trip.algorithm.leet.l24.l07;

import java.util.HashMap;
import java.util.Map;

public class Solution3033 {
    public static void main(String[] args) {

    }

    public int[][] modifiedMatrix(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = matrix[0].length;
        for (int i = 0; i < length; i++) {
            int max = -1;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            map.put(i, max);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = map.get(j);
                }
            }
        }
        return matrix;

    }
}
