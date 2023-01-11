package com.trip.algorithm.codethink.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xbguo
 * @date: 2022/11/7 19:24
 */
public class Solution1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(target - val)) {
                return new int[]{map.get(target - val), i};
            } else {
                map.put(val, i);
            }
        }
        return null;

    }
}
