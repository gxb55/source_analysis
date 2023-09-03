package com.trip.algorithm.leet.leet75.binarylookupproblem;

/**
 * @author xbguo
 * @createTime 2023年09月02日 15:24:00
 */
public class Solution162 {
    public static void main(String[] args) {
        Solution162 solution162 =new Solution162();
        int[] arr={2,1};
        int peakElement = solution162.findPeakElement(arr);
        System.out.println(peakElement);
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        if(right==1){
            return 0;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid+1>=nums.length)||nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
