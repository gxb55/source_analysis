package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/9 14:25
 * @description TODO
 */
public class Solution2529 {
    public static void main(String[] args) {
        int[] arr = {-2, -1, -1, 0, 0, 0};
        int i = maximumCount(arr);
        System.out.println(i);
    }

    public static int maximumCount(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        int mid = -1;
        if (nums[0] >= 0) {
            int i = 0;
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            return nums.length - i;
        }
        if (nums[right] < 0) {
            return nums.length;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == 0) {
                break;
            }
            if (nums[mid] >= 0 && nums[mid - 1] < 0) {
                break;
            }
            if (nums[mid] >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int i = mid;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        int l = mid;
        int r = nums.length - i;
        return Math.max(l, r);
    }
}
