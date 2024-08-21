package com.trip.algorithm.leet.l24.l100;

public class Solution136 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int x=nums[0];
        for (int i = 1; i < nums.length; i++) {
            x=x^nums[i];
        }
        return x;
    }
}
