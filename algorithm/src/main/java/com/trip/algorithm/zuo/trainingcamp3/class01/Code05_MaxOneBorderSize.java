package com.trip.algorithm.zuo.trainingcamp3.class01;

/**
 * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边长长度。
 * 例如:
 * 01111
 * 01001
 * 01001
 * 01111
 * 01011
 * 其中边框全是1的最大正方形的大小为4*4，所以返回4。
 */
public class Code05_MaxOneBorderSize {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        arr[0] = new int[]{0, 0, 0, 0};
        arr[1] = new int[]{1, 0, 1, 1};
        arr[2] = new int[]{1, 0, 1, 1};
        arr[3] = new int[]{1, 1, 1, 1};

        int result = getMax(arr);
    }

    private static int getMax(int[][] arr) {

        int[][] downArr = new int[4][4];
        int[][] rightArr = new int[4][4];
        preArr(arr, downArr, rightArr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int len = 0; len < arr[i].length; len++) {

                }
            }
        }
        return 0;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 预处理数组
     */
    public static void preArr(int[][] arr, int[][] downArr, int[][] rightArr) {
        // 从下往上
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1) {
                    downArr[i][j] = arr[i][j];
                } else {
                    downArr[i][j] = arr[i][j] == 1 ? (1 + downArr[i + 1][j]) : 0;
                }
            }
        }
        // 从左往右
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    rightArr[i][j] = arr[i][j];
                } else {
                    rightArr[i][j] = arr[i][j] == 1 ? 1 + rightArr[i][j - 1] : 0;
                }
            }
        }
    }
}
