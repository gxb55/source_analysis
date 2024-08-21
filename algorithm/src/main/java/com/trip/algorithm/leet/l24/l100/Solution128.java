package com.trip.algorithm.leet.l24.l100;

import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        //  int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(arr);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            min = Math.min(min, nums[i]);
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                continue;
            }
            int left = num;
            int right = num;
            int v = 1;
            while (map.remove(left - 1) != null) {
                v++;
                left--;
            }
            while (map.remove(right + 1) != null) {
                right++;
                v++;
            }

            len = Math.max(v, len);
        }
        return len;
    }
}
