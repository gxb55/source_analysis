package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/13 15:49
 * @description 1827
 */
public class Solution1827 {
    public static void main(String[] args) {
        int[] arr =  {1, 1, 1};
        Solution1827 solution1827 = new Solution1827();
        int i = solution1827.minOperations(arr);
        System.out.println(i);
    }

    public int minOperations(int[] nums) {
        int res = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > last) {

            } else {
                nums[i] = last + 1;
                res = res + (last + 1 - cur);
            }
            last = nums[i];
        }
        return res;
    }
}
