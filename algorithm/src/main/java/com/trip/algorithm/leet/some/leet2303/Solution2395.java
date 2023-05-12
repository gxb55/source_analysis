package com.trip.algorithm.leet.some.leet2303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2023年03月26日 09:47:00
 */
public class Solution2395 {
    public static void main(String[] args) {

    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
