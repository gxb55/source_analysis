package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @createTime 2023年03月26日 15:52:00
 */
public class Solution713 {
    public static void main(String[] args) {
       /* int[] nums = {10, 5, 2, 6};
        int k = 100;*/

       /* int[] nums = {1, 2, 3};
        int k = 0; */

        /*int[] nums = {1, 1, 1};
        int k = 2;*/

        int[] nums = {10, 2, 2, 5, 4, 4, 4, 3, 7, 7};
        int k = 289;

        int i = numSubarrayProductLessThanK(nums, k);
        System.out.println(i);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int cur = 1;
        int count = 0;
        for (; right < nums.length; right++) {
            int num = nums[right];
            cur = cur * num;
            while (cur >= k && left <= right) {
                cur = cur / nums[left];
                left++;
            }
            count = count + (right - left + 1);
        }
        return count;
    }
}
