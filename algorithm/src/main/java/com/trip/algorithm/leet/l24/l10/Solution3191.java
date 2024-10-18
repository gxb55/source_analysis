package com.trip.algorithm.leet.l24.l10;

/**
 * @author xbguo
 * @date 2024/10/18 14:12
 * @description TODO
 */
public class Solution3191 {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i + 2 < nums.length) {
                    nums[i]=1;
                    nums[i+1]=nums[i+1]==1?0:1;
                    nums[i+2]=nums[i+2]==1?0:1;
                    count++;
                } else {
                    return -1;
                }
            }
        }
        return count;
    }
}
