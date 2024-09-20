package com.trip.algorithm.leet.l24.l09;

/**
 * @author xbguo
 * @date 2024/9/19 20:09
 * @description TODO
 */
public class Solution2414 {
    public static void main(String[] args) {

    }

    public int longestContinuousSubstring(String s) {
        char[] charArray = s.toCharArray();
        int[] dp =new int[charArray.length];
        dp[0]=1;
        int max=1;
        for (int i = 1; i < charArray.length; i++) {
            if((charArray[i]-charArray[i-1])==1){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=1;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
