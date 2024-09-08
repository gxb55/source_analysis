package com.trip.algorithm.leet.l24.l100;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public static void main(String[] args) {
       /* int[] nums = {1, 1, 1};
        int k = 2;   */

        int[] nums = {1, 2, 3};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
          /*  Integer v1 = map.getOrDefault(k - num, 0);
            count = count + v1;*/

            sum = sum + num;
            Integer v = map.getOrDefault(sum-k, 0);
            count = count + v;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
