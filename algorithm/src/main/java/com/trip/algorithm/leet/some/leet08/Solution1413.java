package com.trip.algorithm.leet.some.leet08;

/**
 * @author xbguo
 * @date 2022/8/9  17:09
 * @description Solution1413
 */
public class Solution1413 {
    public static void main(String[] args) {
        int[] arr = {-3, 2, -3, 4, 2};
        Solution1413 solution1413 = new Solution1413();
        int i = solution1413.minStartValue(arr);
        System.out.println(i);
    }

    public int minStartValue(int[] nums) {
        int cur = 0;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            cur = cur + num;
            if (cur < 1) {
                res = Math.max(res, 1 - cur);
            }
        }
        return res;
    }
}
