package com.trip.algorithm.leet.some.leet2303;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年03月16日 21:03:00
 */
public class Solution2488 {
    public static void main(String[] args) {
       /* int[] nums = {3, 2, 1, 4, 5};
        int k = 4;*/

       /* int[] nums = {2, 3, 1};
        int k = 3;*/

        int[] nums = {5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14};
        int k = 6;
        System.out.println(Arrays.toString(nums));
        int i = countSubarrays(nums, k);
        System.out.println(i);
    }

    public static int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        int index = 0;
        for (; index < nums.length; index++) {
            if (nums[index] == k) {
                break;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 1;
        int cur = 0;
        for (int i = index - 1; i >= 0; i--) {
            int t = nums[i];
            if (t > k) {
                cur++;
            } else {
                cur--;
            }
            Integer integer = leftMap.get(cur);
            if (integer == null) {
                leftMap.put(cur, 1);
            } else {
                leftMap.put(cur, integer + 1);
            }
            if (cur == 0 || cur == 1) {
                sum++;
            }
            list.addLast(cur);
        }
        cur = 0;
        for (int i = index + 1; i < nums.length; i++) {
            int t = nums[i];
            if (t > k) {
                cur++;
            } else {
                cur--;
            }
            Integer integer = rightMap.get(cur);
            if (integer == null) {
                rightMap.put(cur, 1);
            } else {
                rightMap.put(cur, integer + 1);
            }
            if (cur == 0 || cur == 1) {
                sum++;
            }
            list.addFirst(cur);
        }
        for (Map.Entry<Integer, Integer> x : leftMap.entrySet()) {
            Integer key = x.getKey();
            Integer value = x.getValue();
            Integer integer = rightMap.get(-key);
            if (integer != null) {
                // sum = sum + Math.min(value, integer);
                sum = sum + value * integer;
            }
            integer = rightMap.get(-(key) + 1);
            sum = sum + (integer == null ? 0 : integer) * value;
        }
        System.out.println(list);
        return sum;
    }
}
