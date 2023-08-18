package com.trip.algorithm.leet.leet75.twopointerproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/8/17 16:07
 */
public class Solution1674 {
    public static void main(String[] args) {

    }

    public int maxOperations(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int count = 0;
        Arrays.sort(nums);
        while (left < right) {
            int x = nums[left];
            int y = nums[right];
            int sum = x + y;
            if (sum == k) {
                left++;
                right--;
                count++;
            } else if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            }
        }
        return count;
    }
}
