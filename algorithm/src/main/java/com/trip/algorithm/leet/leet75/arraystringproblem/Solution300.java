package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @date 2023/8/16 19:43
 */
public class Solution300 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                res[i]=res[i+1];
            }else{
                int index=i-1;
                while (index>=0){
                    if(nums[index]<){

                    }
                }
            }
        }
    }
}
