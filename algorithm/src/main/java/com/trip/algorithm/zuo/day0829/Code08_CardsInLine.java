package com.trip.algorithm.zuo.day0829;

/**
 * A B在一个数组中那纸牌，只能从最左边，或者最右边拿
 * 这两个人都非常聪明，问胜利者的分数是多少
 * <p>
 * A 是先手他可以挑选 最左 最右，和后手中最好的
 * B 是后手，他只能挑选
 */
public class Code08_CardsInLine {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 5};
        System.out.println(win(arr));
        System.out.println(winDp(arr));
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 先手函数
     *
     * @return
     */
    public static int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(
                arr[i] + s(arr, i + 1, j)
                , arr[j] + s(arr, i, j - 1)
        );
    }

    /**
     * 后手函数
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }


    public static int winDp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dpF = new int[n + 1][n + 1];
        int[][] dpL = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dpF[i][j] = arr[i];
                    dpL[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = j - 1; j >=0; j--) {
                dpF[i][j] = Math.max((arr[i] + dpL[i + 1][j]), (arr[j] + dpL[i][j - 1]));
                dpL[i][j] = Math.min(dpF[i + 1][j], dpF[i][j - 1]);
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpF[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dpL[i][j] + " ");
            }
            System.out.println();
        }

        return Math.max(dpF[0][n - 1], dpL[0][n - 1]);
    }
}
