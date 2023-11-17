package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/13 14:47
 */
public class Solution307 {
    public static void main(String[] args) {

    }
}

class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}