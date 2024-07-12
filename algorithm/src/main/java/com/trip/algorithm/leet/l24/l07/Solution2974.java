package com.trip.algorithm.leet.l24.l07;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/7/12 19:45
 * @description TODO
 */
public class Solution2974 {

    public static void main(String[] args) {

    }

    public int[] numberGame(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int index=0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            int x=nums[i];
            int y=nums[i+1];
            arr[index++]=y;
            arr[index++]=x;
        }
        return arr;
    }
}
