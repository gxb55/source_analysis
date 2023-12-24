package com.trip.algorithm.leet.some.leet2312;

public class Solution162 {
    public static void main(String[] args) {
        Solution162 solution162 = new Solution162();
        //int[] nums = {1,2,1,3,5,6,4};
        // int[] nums = {1,2,3,1};
       // int[] nums = {1, 2};
        int[] nums = {2, 1};
        int peakElement1 = solution162.findPeakElement1(nums);
        System.out.println(peakElement1);
    }

    public int findPeakElement(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    public int findPeakElement1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (getRes(mid, mid + 1, nums)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean getRes(int mid, int next, int[] nums) {
        if (next >= nums.length) {
            return false;
        }

        return nums[next] > nums[mid];
    }
}
