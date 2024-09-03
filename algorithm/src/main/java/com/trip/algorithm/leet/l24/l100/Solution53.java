package com.trip.algorithm.leet.l24.l100;

public class Solution53 {
    public static void main(String[] args) {

        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last > 0) {
                last = last + nums[i];
            } else {
                last = nums[i];
            }
            res = Math.max(res, last);
        }
        return res;
    }
}
