package com.trip.algorithm.leet.l24.l100;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/9/13 17:13
 */
public class Solution34 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int r = 8;
        int[] ints = searchRange(arr, r);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = nums[mid];
            if (target > midVal) {
                l = mid + 1;
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        if (ans == -1) {
            return new int[]{-1, -1};
        }
        int left = ans;
        int right = ans;
        while (left >=1 && nums[left-1 ] == target) {
            left--;
        }
        while (right  < nums.length-1 && nums[right+1] == target) {
            right++;
        }
        return new int[]{left, right};
    }
}
