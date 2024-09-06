package com.trip.algorithm.leet.l24.l09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/9/4 18:59
 * @description TODO
 */
public class Solution2860 {
    public static void main(String[] args) {
        int[] nums = {6,0,3,3,6,7,2,7};
        int i = countWays(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println(i);
    }

    public static int countWays(List<Integer> nums) {
        int count = 0;
        nums.sort((x, y) -> x - y);
        // 都不选
        if (nums.get(0) > 0) {
            count++;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer integer = nums.get(i);
            if (i == nums.size() - 1) {
                if (integer < (i + 1)) {
                    count++;
                }
            } else {
                //选了当前的同学
                Integer integer1 = nums.get(i + 1);
                if (integer < (i + 1) && integer1 > (i + 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
