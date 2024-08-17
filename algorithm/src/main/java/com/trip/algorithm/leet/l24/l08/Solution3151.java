package com.trip.algorithm.leet.l24.l08;

public class Solution3151 {
    public static void main(String[] args) {

    }
    public boolean isArraySpecial(int[] nums) {
        boolean flag=nums[0]%2==0?true:false;
        for (int i = 1; i < nums.length; i++) {
            boolean flag1=nums[i]%2==0?true:false;
            if(!flag!=flag1){
                return false;
            }
            flag=flag1;
        }
        return true;
    }
}
