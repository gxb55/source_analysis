package com.trip.algorithm.leet.l24.l03;

public class Solution2369 {
    public static void main(String[] args) {

    }

    public boolean validPartition(int[] nums) {
        int length = nums.length;
        if (length == 2) {
            return nums[0] == nums[1];
        } else if (length == 3) {
            return check1(nums, 0, 2) || check2(nums, 0, 2);
        }
        boolean[] arr = new boolean[nums.length];
        arr[1] = check1(nums, 0, 1);
        arr[2] = check2(nums, 0, 2) || check1(nums, 0, 2);
        for (int i = 3; i < arr.length; i++) {
            if (check1(nums, i - 1, i) && arr[i - 2]) {
                arr[i] = true;
            } else if ((check1(nums, i - 2, i) || check2(nums, i - 2, i)) && arr[i - 3]) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }
        return arr[length - 1];
    }

    private boolean check2(int[] nums, int i, int i1) {
        int t = nums[i];
        for (int j = i + 1; j <= i1; j++) {
            if (t + 1 != nums[j]) {
                return false;
            }
            t = nums[j];
        }
        return true;
    }

    private boolean check1(int[] nums, int i, int i1) {
        int t = nums[i];
        for (int j = i; j <= i1; j++) {
            if (t != nums[j]) {
                return false;
            }
        }
        return true;
    }

}
