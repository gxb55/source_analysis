package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/2 18:56
 * @description TODO
 */
public class Solution3115 {
    public static void main(String[] args) {
        int[] arr={4,8,2,8};
        Solution3115 solution3115 =new Solution3115();
        int i = solution3115.maximumPrimeDifference(arr);
        System.out.println(i);
    }

    public int maximumPrimeDifference(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        for (; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                break;
            }
        }
        boolean flag = false;
        for (; j >= 0 & j >= i; j--) {
            if (isPrime(nums[j])) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return Math.abs(j - i);

        }
        return 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
