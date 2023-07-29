package com.trip.algorithm.leet.some.leet2307;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/7/10 16:59
 */
public class Solution16 {
    public static void main(String[] args) {
       /* int[] nums = {-1, 2, 1, -4};
        int target = 1; */
        /*int[] nums = {0, 0, 0};
        int target = 1;*/
       /* int[] nums = {0, 1, 2};
        int target = 0; */

       /* int[] nums = {1,1,1,0};
        int target =-100; */

      /*  int[] nums = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2; */

        int[] nums = {-100,-98,-2,-1};
        int target = -101;

        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer cur = nums[0] + nums[1] + nums[2];
        Integer res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int val = nums[left] + nums[right] + curVal;
                if (val > target) {
                    right--;
                } else if (val < target) {
                    left++;
                }
                if (val == target) {
                    return target;
                }
                if (Math.abs(target - val) < Math.abs(target - res)) {
                    res = val;
                }
            }
        }
        return res;
    }
}
