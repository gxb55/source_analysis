package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @createTime 2023年06月13日 08:23:00
 */
public class Solution2475 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 4, 3};
        int i = unequalTriplets(nums);
        System.out.println(i);
    }

    public static int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
