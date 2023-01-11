package com.trip.algorithm.leet.some.codeThink.arr;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2022年10月31日 21:49:00
 */
public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = solution209.minSubArrayLen1(target, nums);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int max = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            list.addLast(num);
            sum = sum + num;
            while (sum >= target) {
                max = Math.min(max, list.size());
                Integer integer = list.pollFirst();
                sum = sum - integer;
            }
        }
        return max;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum = sum + num;
            while (sum >= target) {
                max = Math.min(max, i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return max;
    }
}
