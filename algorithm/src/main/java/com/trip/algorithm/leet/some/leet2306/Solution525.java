package com.trip.algorithm.leet.some.leet2306;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/16 15:27
 */
public class Solution525 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        int maxLength = findMaxLength(nums);
        System.out.println(maxLength);
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = cur + -1;
            } else {
                cur = cur + 1;
            }
            if (map.containsKey(cur)) {
                max = Math.max(max, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }

        return max;
    }
}
