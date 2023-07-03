package com.trip.algorithm.leet.some.leet2307;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年07月01日 11:13:00
 */
public class Solution01 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int res = target - num;
            Integer integer = map.get(res);
            if (integer != null) {
                return new int[]{i, integer};
            }
        }
        return null;
    }
}
