package com.trip.algorithm.leet.l24.l07;

public class Solution3101 {
    public static void main(String[] args) {
     //   int[] nums = {0, 1, 1, 1};
        int[] nums = {1, 0, 1, 0};
        long l = countAlternatingSubarrays(nums);
        System.out.println(l);
    }

    public static long countAlternatingSubarrays(int[] nums) {
        int left = 0;
        int i = 1;
        long sum = 0;
        for (; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[i - 1]) {
                int count = i - left;
                while (count > 0) {
                    sum += count;
                    count--;
                }
                left = i;
            }
        }
        int count = i - left;
        while (count > 0) {
            sum += count;
            count--;
        }
        return sum;
    }
}
