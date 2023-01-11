package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Classname Solution1636
 * @Description 1636
 * @Date 2022/9/19 13:56
 * @Created by xbguo
 */
public class Solution1636 {
    public static void main(String[] args) {
        Solution1636 solution1636 = new Solution1636();
      //  int[] nums = {2,3,1,3,2};
       // int[] nums = {1,1,2,2,2,3};
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        int[] ints = solution1636.frequencySort(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] frequencySort(int[] nums) {
        int[] arr = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((x, y) -> {
            if (x.getValue() == y.getValue()) {
                return y.getKey()-x.getKey();
            } else {
                return x.getValue() - y.getValue();
            }
        }).collect(Collectors.toList());

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : collect) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            while (value > 0) {
                arr[index] = key;
                index++;
                value--;
            }
        }
        return arr;
    }
}
