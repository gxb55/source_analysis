package com.trip.algorithm.leet.l24.l100;

public class Solution238 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftVal = 1;
        for (int i = 0; i < nums.length; i++) {
            leftVal = leftVal * nums[i];
            left[i] = leftVal;
        }
        leftVal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            leftVal = leftVal * nums[i];
            right[i] = leftVal;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i]=right[1];
            } else if (i == res.length - 1) {
                res[i]=left[res.length - 2];
            } else {
                res[i]=left[i-1]*right[i+1];
            }
        }
        return res;
    }
}
