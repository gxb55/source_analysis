package com.trip.algorithm.leet.some.leet2210;

/**
 * @author xbguo
 * @createTime 2022年10月07日 16:33:00
 */
public class Solution1800 {
    public static void main(String[] args) {
        Solution1800 solution1800 = new Solution1800();
        int[] arr = {10, 20, 30, 5, 10, 50};
         arr = new int[]{10, 20, 30, 40, 50};
         arr = new int[]{12,17,15,13,10,11,12};
         arr = new int[]{100,10,1};
        int i = solution1800.maxAscendingSum(arr);
        System.out.println(i);
    }

    public int maxAscendingSum(int[] nums) {
        int max = -1;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i > 0) {
                if (nums[i] > nums[i - 1]) {
                    max = max + cur;
                } else {
                    max = cur;
                }
            } else {
                max = Math.max(max, cur);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
