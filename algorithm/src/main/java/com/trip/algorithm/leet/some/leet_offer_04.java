package com.trip.algorithm.leet.some;

/**
 * @author xbguo
 * @createTime 2022年04月04日 16:13:00
 * <p>
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 */
public class leet_offer_04 {
    public static void main(String[] args) {
        leet_offer_04 leet_offer_04 = new leet_offer_04();
        /*int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/
        int[][] arr = {
                {1, 4},
                {2, 5},
              };
        int target = 1;
        boolean numberIn2DArray = leet_offer_04.findNumberIn2DArray1(arr, target);
        System.out.println(numberIn2DArray);
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }
        if (matrix.length == 1) {
            return getResult(matrix[0], target);
        }
        if (matrix[0].length == 1) {
            int t[] = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                t[i] = matrix[i][0];
            }
            return getResult(t, target);
        }
        int x = matrix.length;
        int y = matrix[0].length;
        for (int i = 0; i < x; i++) {
            if (matrix[i][0] <= target && matrix[i][y - 1] >= target) {
                for (int j : matrix[i]) {
                    if (j == target) {
                        return true;
                    }
                }
            }
            if (matrix[i][0] > target) {
                break;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }
        if (matrix.length == 1) {
            return getResult(matrix[0], target);
        }
        if (matrix[0].length == 1) {
            int t[] = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                t[i] = matrix[i][0];
            }
            return getResult(t, target);
        }
        // 行
        int len = matrix.length;
        // 第一行
        int[] arr = matrix[0];
        // 第一列
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            arr1[i] = matrix[i][0];
        }
        // 第一行
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int val = arr[mid];
            if (val > target) {
                right = mid - 1;
            } else if (target > val) {
                left = left + 1;
            } else {
                return true;
            }
        }
        if (matrix[0][left] > target) {
            left--;
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = matrix[i][left];
        }
        if (getResult(result, target)) {
            return true;
        }
        // 第一列
        int left2 = 0;
        int right1 = arr1.length - 1;
        while (left2 < right1) {
            int mid = (left2 + right1) / 2;
            int val = arr1[mid];
            if (val > target) {
                right1 = mid - 1;
            } else if (target > val) {
                left2 = left2 + 1;
            } else {
                return true;
            }
        }
        if (matrix[left2][0] > target) {
            left2--;
        }
        int[] result1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result1[i] = matrix[left2][i];
        }
        return getResult(result1, target);
    }

    private boolean getResult(int[] result, int target) {
        int left = 0;
        int right = result.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int val = result[mid];

            if (val > target) {
                right = right - 1;
            } else if (target > val) {
                left = left + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
