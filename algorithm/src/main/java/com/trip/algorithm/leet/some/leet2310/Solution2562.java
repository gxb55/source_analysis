package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/12 10:56
 */
public class Solution2562 {
    public static void main(String[] args) {
        int[] arr={7,52,2,4};
        long theArrayConcVal = findTheArrayConcVal(arr);
        System.out.println(theArrayConcVal);
    }
    public static long findTheArrayConcVal(int[] nums) {
        int left=0;
        int right=nums.length-1;
        long sum=0;
        while (left<right){
            Integer integer = Integer.valueOf(nums[left] + "" + nums[right]);
            sum+=integer;
            left++;
            right--;
        }
        if(left==right){
            sum+=nums[left];
        }

        return sum;
    }
}
