package com.trip.algorithm.leet.l24.l07;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/7/26 09:45
 */
public class Solution2740 {

    public static void main(String[] args) {

    }

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int abs = Math.abs(nums[i] - nums[i - 1]);
            res = Math.min(res, abs);
        }
        return res;
    }
}
