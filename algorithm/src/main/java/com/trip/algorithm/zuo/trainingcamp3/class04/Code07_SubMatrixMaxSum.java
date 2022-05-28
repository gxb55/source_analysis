package com.trip.algorithm.zuo.trainingcamp3.class04;

/**
 * 给定一个整型矩阵，返回子矩阵的最大累计和。
 */
public class Code07_SubMatrixMaxSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {-90, 48, 78},
                {64, -40, 64},
                {-81, -7, 66}
        };
        System.out.println(maxSum(matrix));
    }

    /**
     * 压缩数组，
     * 1.先枚举情况
     * 2.将情况中包含的数组压缩，然后当做一维数组来求解
     *
     * @param arr
     * @return
     */
    public static int maxSum(int[][] arr) {
        if (arr == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int x = arr.length;
        int y = arr[0].length;
        //从i行 到 j行
        //res[k] = res[k] + arr[j][k]; 相当于到哪一行就算到哪一行
        for (int i = 0; i < x; i++) {
            int[] res = new int[y];
            for (int j = i; j < x; j++) {
                int cur = 0;
                for (int k = 0; k < y; k++) {
                    res[k] = res[k] + arr[j][k];
                    cur = cur + res[k];
                    max = Math.max(cur, max);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
