package com.trip.algorithm.zuo.trainingcamp3.class02;

/**
 * 在行也有序、列也有序的二维数组中，找num，找到返回true，否则false
 */
public class Code01_FindNumInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }

    /**
     * 从左到右 从小到大
     * 从上往下 从下到大
     *
     * @param matrix
     * @param k
     * @return
     */
    private static boolean isContains(int[][] matrix, int k) {
        // 右上角开始比较
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && i >= 0 && j < matrix[0].length && j >= 0) {
            if (matrix[i][j] > k) {
                j = j - 1;
            } else if (matrix[i][j] < k) {
                i = i + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
