package com.trip.algorithm.leet.zs;

/**
 * @author xbguo
 * @createTime 2022年03月28日 21:39:00
 * <p>
 * 给你两个数组 a b
 * a中的任意位置可以跟b中对应的位置交换位置，问是否能让a升序排列
 */
public class Code02_LetASort {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 60, 9, 0};
        int[] b = {3, 1, 6, 78, 9, 91};
        boolean flag = canSort(a, b);
        System.out.println(flag);
        System.out.println(canSort1(a, b));
    }

    private static boolean canSort(int[] a, int[] b) {
        return process(a, b, 0, false);
    }

    /**
     * @param a     数组a
     * @param b     数组b
     * @param index 当前下标  ；当前下标之前的所有数字都合法有序了
     * @param swap  上一个树是否交换；这个数字来判断，index是否可以满足要求
     *              两种情况，当前数字交换，当前数字不交换，任一可以满足都是可以的
     * @return
     */
    private static boolean process(int[] a, int[] b, int index, boolean swap) {
        if (index == a.length) {
            return true;
        }
        int last;
        if (index == 0) {
            last = Integer.MIN_VALUE;
        } else {
            last = swap ? b[index - 1] : a[index - 1];
        }
        // 交换
        boolean p1 = b[index] < last ? false : process(a, b, index + 1, true);
        // 不交换
        boolean p2 = a[index] < last ? false : process(a, b, index + 1, false);
        return p1 || p2;
    }

    /**
     * 根据上面的递归来尝试改动态规划 可变参数有两个，且是从左到右的模型
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean canSort1(int[] a, int[] b) {
        int len = a.length;
        // 0没有交换；1交换了；
        int[][] dp = new int[2][len];
        dp[0][0] = a[0];
        dp[1][0] = b[0];
        for (int i = 1; i < len; i++) {
            int min = Math.min(dp[0][i - 1], dp[1][i - 1]);
            int aCur = a[i];
            if (aCur >= min) {
                dp[0][i] = aCur;
            }
            int bCur = b[i];
            if (bCur >= min) {
                dp[1][i] = bCur;
            }
            if (aCur >= min || bCur >= min) {

            } else {
                return false;
            }
        }
        return true;
    }

}
