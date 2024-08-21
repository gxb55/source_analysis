package com.trip.algorithm.leet.l24.l100;

public class Solution215 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] arr = {3, 2, 1, 5, 6, 4};
        int t = 2;
        int kthLargest = solution215.findKthLargest(arr, t);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    private int find(int[] nums, int k, int left, int right) {
        if (left == k + 1) {
            return nums[left];
        }
        // 从大到小，降序，然后找前几个就可了
        int l = left;
        int r = right;
        int mid = right;
        while (l < r) {
            while (l < r && nums[l] >= nums[mid]) {
                l++;
            }
            while (l < r && nums[r] <= nums[mid]) {
                r--;
            }
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        int t = nums[mid];
        nums[mid] = nums[l];
        nums[l] = t;
        if (k < (l-1)) {
            return find(nums, k, l + 1, r);
        } else if (k > (l-1)) {
            return find(nums, k, left, l);
        } else {
            return nums[l];
        }

    }
}
