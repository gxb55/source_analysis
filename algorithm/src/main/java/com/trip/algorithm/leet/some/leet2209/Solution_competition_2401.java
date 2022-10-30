package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月17日 12:11:00
 */
public class Solution_competition_2401 {
    public static void main(String[] args) {
        Solution_competition_2401 solution = new Solution_competition_2401();
       // int[] arr = {1, 3, 8, 48, 10};
      //  int[] arr = {3,1,5,11,13};
        int[] arr = {744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664};
        int i = solution.longestNiceSubarray(arr);
        System.out.println(i);
    }

    public int longestNiceSubarray(int[] nums) {
        int max = 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            boolean flag =true;
            for (int j = i - 1; j >= 0; j--) {
                long i1 = num & nums[j];
                if (i1 != 0) {
                    flag=false;
                    max = Math.max(max, i - j);
                    break;
                }
            }
            if(flag){
                max = Math.max(max, i );
            }
        }
        return max;
    }
}
