package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/8 19:41
 */
public class Solution724 {
    public static void main(String[] args) {
        int[] arr={1, 7, 3, 6, 5, 6};
        int i = pivotIndex(arr);
        System.out.println(i);
    }

    public  static int pivotIndex(int[] nums) {
        int left=0;
        int right= 0;
        for (int x:nums){
            right+=x;
        }
        right=right-nums[0];
        if(left==right){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            left+=nums[i-1];
            right-=num;
            if(left==right){
                return i;
            }
        }
        return -1;
    }
}
