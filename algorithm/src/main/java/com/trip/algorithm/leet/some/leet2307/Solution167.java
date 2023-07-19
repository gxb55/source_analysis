package com.trip.algorithm.leet.some.leet2307;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年07月09日 10:58:00
 */
public class Solution167 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            Integer integer = map.get(target - cur);
            if (integer != null && integer != i) {
                return new int[]{i+1, integer+1};
            }
        }
        return null;
    }
}
