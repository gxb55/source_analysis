package com.trip.algorithm.leet.l24.l03;

public class Solution2908 {
    public static void main(String[] args) {

    }

    public int minimumSum(int[] nums) {
        int len = nums.length;
        int min = -1;
        for (int i = 1; i < len - 1; i++) {
            int num = nums[i];
            int left = num;
            int right = num;
            for (int j = 0; j < i; j++) {
                int leftVal = nums[j];
                if (num > leftVal) {
                    left = Math.min(leftVal, left);
                }
            }
            for (int j = i + 1; j < len; j++) {
                int rightVal = nums[j];
                if (num > rightVal) {
                    right = Math.min(rightVal, right);
                }
            }
            if (num == left || num == right) {

            } else {
                if (min == -1) {
                    min = left + num + right;
                } else {
                    min = Math.min(min, left + num + right);
                }
            }
        }
        return min;
    }
}
