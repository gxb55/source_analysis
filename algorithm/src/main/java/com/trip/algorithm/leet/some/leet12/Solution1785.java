package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/16 16:51
 * @description Solution1785
 */
public class Solution1785 {
    public static void main(String[] args) {
        Solution1785 solution1785 = new Solution1785();
       /* int[] nums = {1, -1, 1};
        int limit = 3, goal = -4;*/

        int[] nums = {1, -10, 9, 1};
        int limit = 100, goal = 0;
        int i = solution1785.minElements(nums, limit, goal);
        System.out.println(i);
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long val = goal - sum;
        if (val == 0) {
            return 0;
        }
        return (int) (Math.abs(val) / limit + (Math.abs(val) % limit == 0 ? 0 : 1));

    }
}
