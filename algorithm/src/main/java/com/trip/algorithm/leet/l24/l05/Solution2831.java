package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author xbguo
 * @date 2024/5/23 14:26
 */
public class Solution2831 {

    public static void main(String[] args) {
        //   List<Integer> nums = List.of(1,3,2,3,1,3);int  k = 3;
        //   List<Integer> nums = List.of(1,1,2,2,1,1);int  k = 2;
        //   List<Integer> nums = List.of(6,4,7,6,4,8,6,6);int  k = 1;
        List<Integer> nums = List.of(4, 2, 7, 2, 1, 7, 2);
        int k = 1;
        int i = longestEqualSubarray(nums, k);
        System.out.println(i);
    }

    public static int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer integer = nums.get(i);
            List<Integer> orDefault = map.getOrDefault(integer, new ArrayList<>());
            orDefault.add(i);
            map.put(integer, orDefault);
        }
        int max = 0;
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            int left = 0;
            int right = 0;
            for (; right < value.size(); right++) {
                while (left < right && value.get(right) - value.get(left) - (right - left) > k) {
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

}
