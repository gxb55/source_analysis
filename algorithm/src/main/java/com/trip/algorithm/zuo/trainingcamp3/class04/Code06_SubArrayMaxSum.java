package com.trip.algorithm.zuo.trainingcamp3.class04;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 */
public class Code06_SubArrayMaxSum {
    public static void main(String[] args) {
        int[] arr = {-1, 1};
        int i = maxSum(arr);
        System.out.println(i);
    }

    /**
     * 有点动态规划的意思，以每个位置结尾的最大值，如果小于0则重置为0，
     * 重置为0 可以认为是不要前面的串，从当前位置开始计算
     *
     * @param arr
     * @return
     */
    public static int maxSum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (Integer i : arr) {
            cur = cur + i;
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
