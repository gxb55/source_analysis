package com.trip.algorithm.leet.leet75.twopointerproblem;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年08月20日 11:59:00
 */
public class Solution283 {
    public static void main(String[] args) {
        int[] arr = {0};
        //  int[] arr={0,1,0,3,12};
        // int[] arr = {0, 0, 1};
        moveZeroes1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes1(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        while (right < nums.length) {
            while (left < len && nums[left] != 0) {
                left++;
            }
            while (right < len && right < left) {
                right++;
            }
            while (right < len && nums[right] == 0) {
                right++;
            }
            if(left>=len||right>=len){
                return;
            }
            int k = nums[left];
            nums[left] = nums[right];
            nums[right] = k;
            left++;
            right++;
        }
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            if (nums[right] == 0) {
                count++;
                for (int i = right; i < nums.length - 1; i++) {
                    nums[i] = nums[i + 1];
                }
            }
            right--;
        }
        int lastIndex = nums.length - 1;
        while (count > 0) {
            nums[lastIndex] = 0;
            count--;
            lastIndex--;
        }
    }
}
