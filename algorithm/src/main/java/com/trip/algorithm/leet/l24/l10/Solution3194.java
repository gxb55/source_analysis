package com.trip.algorithm.leet.l24.l10;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/10/16 19:43
 * @description TODO
 */
public class Solution3194 {
    public static void main(String[] args) {

    }

    public double minimumAverage(int[] nums) {
        int l = 0;
        Arrays.sort(nums);
        int r = nums.length - 1;
        double max = nums[r];
        while (l < r) {
        max=Math.min(max,(nums[l]+nums[r])/2.0);
        l++;
        r--;
        }
        return max;
    }
}
