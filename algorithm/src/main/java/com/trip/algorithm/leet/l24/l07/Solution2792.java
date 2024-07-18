package com.trip.algorithm.leet.l24.l07;

public class Solution2792 {
    public static void main(String[] args) {
        int[] arr = { 4, 4};
        long l = incremovableSubarrayCount1(arr);
        System.out.println(l);
    }

    public static long incremovableSubarrayCount(int[] nums) {
        int left = 0;
        while (left < nums.length - 1 && nums[left] < nums[left + 1]) {
            left++;
        }
        if (left == nums.length - 1) {
            return (nums.length * (nums.length - 1)) / 2;
        }
        // left是下标，则是left+1个书 left+2是全部移除
        int ans = left + 2;
        for (int i = nums.length - 1; i == nums.length - 1 || nums[i] < nums[i + 1]; i--) {
            int num = nums[i];
            while (left >= 0 && nums[left] >= num) {
                left--;
            }
            ans = ans + left + 2;
        }
        return ans;
    }
    public  static int incremovableSubarrayCount1(int[] a) {
        int n = a.length;
        int i = 0;
        while (i < n - 1 && a[i] < a[i + 1]) {
            i++;
        }
        if (i == n - 1) { // 每个非空子数组都可以移除
            return n * (n + 1) / 2;
        }

        int ans = i + 2; // 不保留后缀的情况，一共 i+2 个
        // 枚举保留的后缀为 a[j:]
        for (int j = n - 1; j == n - 1 || a[j] < a[j + 1]; j--) {
            while (i >= 0 && a[i] >= a[j]) {
                i--;
            }
            // 可以保留前缀 a[:i+1], a[:i], ..., a[:0] 一共 i+2 个
            ans += i + 2;
        }
        return ans;
    }


}
