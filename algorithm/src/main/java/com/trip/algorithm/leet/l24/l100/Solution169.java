package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/8/9 16:40
 */
public class Solution169 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int t = nums.length / 2;
        Map<Integer, List<Integer>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x -> x));
        Map.Entry<Integer, List<Integer>> entry = collect.entrySet().stream().filter(x -> x.getValue().size() > t).findFirst().get();
        return entry.getKey();
    }

    public int majorityElement1(int[] nums) {
        int t = 1, val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (t == 0) {
                t = 1;
                val = num;
                continue;
            }
            if (num == val) {
                t++;
            } else {
                t--;
            }
        }
        return val;
    }

}
