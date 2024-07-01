package com.trip.algorithm.leet.l24.l06;

import java.util.HashMap;
import java.util.Map;

public class Solution494 {
    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int targetSumWays = solution494.findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, new HashMap<>());
        }
        int process = process(0, 0, target, nums, map);
        return process;
    }

    private int process(int index, int val, int target, int[] nums, Map<Integer, Map<Integer, Integer>> map) {
        if (index >= nums.length) {
            if (val == target) {

                return 1;
            }
            return 0;
        }
        Integer i = map.get(index).get(val);
        if (i != null) {
            return i;
        }
        int sum = 0;
        int p1 = process(index + 1, val + nums[index], target, nums, map);
        int p2 = process(index + 1, val - nums[index], target, nums, map);
        sum = sum + p1 + p2;
        map.get(index).put(val, sum);
        return sum;
    }
}
