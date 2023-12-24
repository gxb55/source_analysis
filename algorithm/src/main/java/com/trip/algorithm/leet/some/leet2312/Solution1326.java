package com.trip.algorithm.leet.some.leet2312;

public class Solution1326 {
    public static void main(String[] args) {
       /* int n = 5;
        int[] ranges = {3, 4, 1, 1, 0, 0}; */

      /*  int n = 3;
        int[] ranges = {0, 0, 0, 0, 0, 0}; */

        int n = 3;
        int[] ranges = {1, 0, 0, 1};

        int i = minTaps(n, ranges);
        System.out.println(i);
    }

    public static int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int range = ranges[i];
            if(range==0){
                continue;
            }
            int left = Math.max(0, i - range);
            int right = Math.min(n, i + range);
            dp[left] = Math.max(dp[left], right);
        }
        int cur = 0, pre = 0, res = 0;
        for (int i = 0; i < n; i++) {
            // 从0开始能够达到的最远距离
            cur = Math.max(dp[i], cur);
            // 能达到的最远距离小于当前的下标，说明当前距离不能达到
            if (i >= cur) {
                return -1;
            }
            // 0开始能达到的最远距离，然后在0-最远距离直接找一个能达到最远距离的数字
            if (i == (pre)) {
                pre = cur;
                    res++;

            }
        }
        return res;
    }
}
