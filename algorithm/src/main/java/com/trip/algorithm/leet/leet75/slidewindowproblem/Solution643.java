package com.trip.algorithm.leet.leet75.slidewindowproblem;

/**
 * @author xbguo
 * @createTime 2023年08月25日 22:38:00
 */
public class Solution643 {
    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if ((i - left + 1) > k) {
                sum -= nums[left];
                left++;
            }
            if((i - left + 1) == k){
                max = Math.max(max, sum / k);
            }

        }
        return max;
    }
}
