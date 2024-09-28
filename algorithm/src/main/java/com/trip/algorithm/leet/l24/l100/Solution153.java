package com.trip.algorithm.leet.l24.l100;

public class Solution153 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int min = findMin(arr);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return find(l, r, nums);
    }

    private static int find(int l, int r, int[] nums) {
        if (l >= r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[l] > nums[r]) {
            return Math.min(find(l, mid, nums), find(mid + 1, r, nums));
        } else {
            return find(l, mid, nums);
        }

    }
}
