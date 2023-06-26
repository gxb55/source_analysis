package com.trip.algorithm.leet.some.leet2306;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年06月04日 18:32:00
 */
public class Solution2465 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 0, 3, 5};
        int i = distinctAverages(nums);
        System.out.println(i);
    }

    public static int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int i = nums[left] + nums[right];
            double v = i / 0.1;
            set.add(v);
            left++;
            right--;
        }
        return set.size();
    }
}
