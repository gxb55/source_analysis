package com.trip.algorithm.leet.l24.l06;

/**
 * @author xbguo
 * @date 2024/6/7 09:31
 */
public class Solution3038 {
    public static void main(String[] args) {

    }

    public int maxOperations(int[] nums) {
        int sum = nums[0] + nums[1];
        int count = 1;
        for (int i = 2; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) == sum) {
                count++;
                i++;
            }else {
                break;
            }
        }
        return count;
    }
}
