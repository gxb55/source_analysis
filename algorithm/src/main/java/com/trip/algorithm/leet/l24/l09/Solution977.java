package com.trip.algorithm.leet.l24.l09;

import java.util.Arrays;

public class Solution977 {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}
