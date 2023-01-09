package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/25 14:08
 * @description: Solution221
 */
public class Solution221 {
    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
       // char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        //char[][] arr = {{'0','1'},{'1','0'}};
       // char[][] arr = {{'0'}};
        char[][] arr = {
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}
        };
       // char[][] arr = {{'1'}};
       // char[][] arr = {{'1','0'}};
        int i = solution221.maximalSquare(arr);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int length = matrix.length;
        int length1=matrix[0].length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (matrix[i][j] == '1') {
                    int k = 1;
                    int val = 1;
                    t:
                    while (true) {
                        if ((i + k) >= length || (j + k) >= length1) {
                            break;
                        }
                        for (int l = i; l <= i + k; l++) {
                            System.out.println(l+"-"+j);
                            if (matrix[l][j] != '1') {
                                break t;
                            }
                        }
                        System.out.println("------------------");
                        for (int m = j; m <= j + k; m++) {
                            System.out.println(i+"-"+m);
                            if (matrix[i][m] != '1') {
                                break t;
                            }
                        }
                        k++;
                        val = k * k;
                    }
                    max = Math.max(max, val);
                }
            }
        }
        return max;
    }
}
