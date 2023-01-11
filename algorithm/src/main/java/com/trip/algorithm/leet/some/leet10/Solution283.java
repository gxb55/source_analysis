package com.trip.algorithm.leet.some.leet10;

import java.util.Arrays;

/**
 * @auther: xbguo
 * @date: 2022/10/31 16:15
 * @description: Solution283
 */
public class Solution283 {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] arr = {0, 1, 3, 0, 12};
        solution283.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        int fastIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            int cur = nums[fastIndex];
            if (cur == 0) {

            } else {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        for (; slowIndex < nums.length; slowIndex++) {
            nums[slowIndex] = 0;
        }
    }
}
