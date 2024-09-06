package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/9/6 14:47
 * @description TODO
 */
public class Solution189 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index=0;
        for (int i = k; i < collect.size(); i++) {
            nums[i]=collect.get(index);
            index++;
        }
        for (int i = 0; i < k; i++) {
            nums[i]=collect.get(index);
            index++;
        }
    }
}
