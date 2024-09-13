package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/9/12 15:25
 */
public class Solution240 {
    public static void main(String[] args) {
       /* int[][] arr={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}

        };
        int r=5;*/

        int[][] arr = {
                {3, 3, 8, 13, 13, 18},
                {4, 5, 11, 13, 18, 20},
                {9, 9, 14, 15, 23, 23},
                {13, 18, 22, 22, 25, 27},
                {18, 22, 23, 28, 30, 33},
                {21, 25, 28, 30, 35, 35},
                {24, 25, 33, 36, 37, 40}
        };
        int r = 21;
        boolean b = searchMatrix(arr, r);
        System.out.println(b);
    }

    /**
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int max = matrix[i][matrix[i].length - 1];
            if (target > max) {
                continue;
            }
            if (target == min || target == max) {
                return true;
            }
            if (target > min && target < max) {
                int[] matrix1 = matrix[i];
                int l = 0;
                int r = matrix1.length - 1;
                int k = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    int midVal = matrix1[mid];
                    if (midVal == target) {
                        return true;
                    }
                    if (midVal > target) {
                        r = mid - 1;
                    } else {
                        k = mid;
                        l = mid + 1;
                    }
                }
                if (k != -1) {
                    for (int y = 0; y < k; y++) {
                        for (int j = i; j < matrix.length; j++) {
                            if (matrix[j][y] == target) {
                                return true;
                            }
                            if (matrix[j][y] > target) {
                              break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
