package com.trip.algorithm.leet.l24.l08;

import java.util.Arrays;

public class Solution31 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
       /* arr = new int[]{3, 2, 1};*/
        arr = new int[]{4,2,0,2,3,2,0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int min = -1;
        int max = -1;
        int i = nums.length - 1;
        for (; i > 0; i--) {
            int cur = nums[i];
            int pre = nums[i - 1];
            if (cur > pre) {
                min = i-1;
                break;
            }
        }
        if (min == -1) {
            change(nums, 0, nums.length - 1);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if(nums[j]<=nums[min]){
                max=j-1;
                break;
            }
        }
        if(max==-1){
            max=nums.length-1;
        }
        int num = nums[min];
        nums[min] = nums[max];
        nums[max] = num;
        change(nums, min+1, nums.length - 1);
    }

    private static void change(int[] nums, int left, int right) {
        while (left <= right) {
            int num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
            left++;
            right--;
        }
    }
}
