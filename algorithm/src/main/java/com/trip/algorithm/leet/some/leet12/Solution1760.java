package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/22 10:16
 * @description Solution1760
 */
public class Solution1760 {
    public static void main(String[] args) {
        Solution1760 solution1760 = new Solution1760();
        int[] nums = {2, 4, 8, 2};
        int maxOperations = 4;
        int i = solution1760.minimumSize(nums, maxOperations);
        System.out.println(i);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int min = 1;
        int max = 1;
        for (int x : nums) {
            max = Math.max(x, max);
        }
        int pos = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int x : nums) {
                int count = (x - 1) / mid;
                cnt += count;
            }
            if (cnt > maxOperations) {
                min = mid + 1;
            } else {
                pos = mid;
                max = mid - 1;
            }
        }
        return pos;
    }
}
