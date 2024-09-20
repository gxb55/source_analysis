package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/9/20 10:09
 */
public class Solution33 {
    public static void main(String[] args) {
      /*  int[] arr = {4, 5, 6, 7, 0, 1, 2,3};
        int t = 3;*/

        int[] arr = {3, 5, 1};
        int t = 5;
        int search = search(arr, t);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        return find(nums, l, r, target);

    }

    private static int find(int[] nums, int l, int r, int target) {
        if (l < nums.length && nums[l] == target) {
            return l;
        }
        if (r >= 0 && nums[r] == target) {
            return r;
        }
        if (l >= r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[l] > nums[r]) {
            int i = find(nums, mid + 1, r, target);
            if (i != -1) {
                return i;
            }
            return find(nums, l, mid - 1, target);
        } else {
            if (target > nums[mid]) {
                return find(nums, mid + 1, r, target);
            } else {
                return find(nums, l, mid - 1, target);
            }
        }
    }
}
