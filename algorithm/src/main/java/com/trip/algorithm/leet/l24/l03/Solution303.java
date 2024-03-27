package com.trip.algorithm.leet.l24.l03;

public class Solution303 {
    public static void main(String[] args) {

    }
}

class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum=new int[nums.length];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            sum[i]=count;
        }
    }

    public int sumRange(int left, int right) {
        if(left==0){
            return sum[right];
        }
        return sum[right]-sum[left-1];
    }
}