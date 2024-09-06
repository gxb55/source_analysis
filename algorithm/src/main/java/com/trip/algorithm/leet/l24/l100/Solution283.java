package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/9/6 14:52
 */
public class Solution283 {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex <= rightIndex && rightIndex < nums.length) {
            while (leftIndex < nums.length && nums[leftIndex] != 0) {
                leftIndex++;
            }
            if (leftIndex >= nums.length) {
                break;
            }
            rightIndex = leftIndex + 1;
            while (rightIndex < nums.length && nums[rightIndex] == 0) {
                rightIndex++;
            }
            if (rightIndex >= nums.length) {
                break;
            }
            int num = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = num;
        }
    }
}
