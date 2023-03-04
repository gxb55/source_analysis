package com.trip.algorithm.leet.some.leet2302;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/2/24 17:16
 */
public class Solution2357 {
    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (true) {
            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            if (sum == 0) {
                break;
            }
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if (cur > 0 && k == 0) {
                    nums[i] = 0;
                    k = cur;
                }
                if (k > 0) {
                    nums[i] = Math.max(0, cur - k);
                }
            }
            count++;
        }
        return count;
    }
}
