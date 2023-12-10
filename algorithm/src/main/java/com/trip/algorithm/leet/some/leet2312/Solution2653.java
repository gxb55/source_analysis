package com.trip.algorithm.leet.some.leet2312;

import java.util.Arrays;

public class Solution2653 {
    public static void main(String[] args) {
        Solution2653 solution2653 = new Solution2653();
        int[] nums = {1, -1, -3, -2, 3};
        int k = 3, x = 2;
        int[] subarrayBeauty = solution2653.getSubarrayBeauty(nums, k, x);
        System.out.println(Arrays.toString(subarrayBeauty));
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] countArr = new int[100];
        for (int i = 0; i < k - 1; i++) {
            int num = nums[i];
            countArr[num + 50]++;
        }
        int[] arr = new int[nums.length - k + 1];
        int index = 0;
        for (int i = k - 1; i < nums.length; i++, index++) {

            countArr[nums[i] + 50]++;
            Integer val = 0;
            int t=x;
            for (int j = 0; j < countArr.length; j++) {
                int v = countArr[j];
                t-=v;
                if(t<=0){
                    val=j-50;
                    break;
                }
            }

            if (val < 0) {
                arr[index] = val;
            } else {
                arr[index] = 0;
            }
            countArr[(Integer.valueOf(nums[i - k + 1])) + 50]--;
        }

        return arr;
    }
}
