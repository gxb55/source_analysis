package com.trip.algorithm.leet.l24.l06;

import java.util.Arrays;

public class Solution3040 {
    public static void main(String[] args) {
        Solution3040 solution3040 = new Solution3040();
        // int[] nums = {3, 2, 1, 2, 3, 4};
        //  int[] nums = {3, 2, 6, 1, 4};
        int[] nums = {1, 9, 7, 3, 2, 7, 4, 12, 2, 6};
        int i = solution3040.maxOperations(nums);
        System.out.println(i);
    }

    public int maxOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        arr =new int[nums.length][nums.length];
        for (int[] ints : arr) {
            Arrays.fill(ints,-1);
        }
        int max = process(left, right, -1, nums);
        return max;
    }

    public int[][] arr;

    private int process(int left, int right, int val, int[] nums) {
        if (left >= right) {
            return 0;
        }
        Integer i = arr[left][right];
        if (i != -1) {
            return i;
        }
        if (val == -1) {
            int p1 = process(left + 1, right - 1, nums[left] + nums[right], nums) + 1;
            int p2 = process(left + 2, right, nums[left] + nums[left + 1], nums) + 1;
            int p3 = process(left, right - 2, nums[right - 1] + nums[right], nums) + 1;
            return Math.max(Math.max(p1, p3), p2);
        } else {
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            if ((nums[left] + nums[right]) == val) {
                p1 = process(left + 1, right - 1, nums[left] + nums[right], nums) + 1;
            }
            if ((nums[left] + nums[left + 1]) == val) {
                p2 = process(left + 2, right, nums[left] + nums[left + 1], nums) + 1;
            }
            if ((nums[right - 1] + nums[right]) == val) {
                p3 = process(left, right - 2, nums[right - 1] + nums[right], nums) + 1;
            }
            int max = Math.max(Math.max(p1, p3), p2);
            arr[left][right]=max;
            return max;
        }

    }
}
