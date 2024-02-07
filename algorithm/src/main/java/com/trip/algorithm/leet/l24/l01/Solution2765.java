package com.trip.algorithm.leet.l24.l01;

public class Solution2765 {
    public static void main(String[] args) {
        Solution2765 solution2765 = new Solution2765();
        // int[] nums = {2, 3, 4, 3, 4};
        // int[] nums = {31,32,31,32,33};
        int[] nums = {21, 9, 5};
        int i = solution2765.alternatingSubarray(nums);
        System.out.println(i);
    }

    public int alternatingSubarray(int[] nums) {
        int max = 0;
        int left = -1;
        int lastVal = -1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == -lastVal) {
                if (left == -1) {
                    left = i - 1;
                }
                lastVal = -lastVal;
            } else {
                if(left!=-1){
                    max = Math.max(max, i - left);
                }

                left = -1;
                lastVal = -1;
                if ((nums[i] - nums[i - 1]) == -lastVal) {
                    if (left == -1) {
                        left = i - 1;
                    }
                    lastVal = -lastVal;
                }
            }
        }
        if (left != -1) {
            max = Math.max(max, nums.length - left);
        }
        return max;
    }
}
