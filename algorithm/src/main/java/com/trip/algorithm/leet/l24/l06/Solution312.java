package com.trip.algorithm.leet.l24.l06;

import java.util.Arrays;

public class Solution312 {
    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        int[] arr = {3, 1, 5, 8};
        int i = solution312.maxCoins(arr);
        System.out.println(i);
    }

    public int maxCoins(int[] nums) {
        int length = nums.length;
        dp = new int[length + 2][length + 2];
        arr = new int[length + 2];
        for (int i = 0; i < length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[length+1] = 1;
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return process(0, length + 1);
    }

    int[][] dp;
    int[] arr;

    private int process(int left, int right) {
        if (left >= right-1) {
            return 0;
        }

        int i = dp[left][right];
        if (i != -1) {
            return i;
        }
        for (int j = left + 1; j < right; j++) {
            int val =arr[left]* arr[j]*arr[right];
            int leftVal = process(left, j);
            int rightVal = process(j, right);
            dp[left][right] = Math.max(leftVal + rightVal + val, dp[left][right]);
        }
        return dp[left][right];
    }
}
