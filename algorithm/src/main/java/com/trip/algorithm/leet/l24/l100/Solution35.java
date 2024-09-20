package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/9/13 16:11
 */
public class Solution35 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 11};
        int target = -1;
        int i = searchInsert(arr, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int v = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (target > midVal) {
                v = mid;
                l = mid + 1;
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return v+1;
    }
}
