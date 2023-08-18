package com.trip.algorithm.leet.leet75.bitoperationproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/8/17 15:06
 */
public class Solution136 {
    public static void main(String[] args) {

    }

    public int singleNumber1(int[] nums) {
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = cur ^ nums[i];
        }
        return cur;
    }

    public int singleNumber(int[] nums) {
        List<Integer> set = new ArrayList<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(Integer.valueOf(x));
            } else {
                set.add(x);
            }
        }
        return set.get(0);
    }
}
