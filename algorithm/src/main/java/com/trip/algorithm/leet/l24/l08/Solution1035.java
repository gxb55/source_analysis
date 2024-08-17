package com.trip.algorithm.leet.l24.l08;

public class Solution1035 {
    public static void main(String[] args) {
        int[] nums1 =  {1,3,7,1,7,5}, nums2 = {1,9,2,5,1};
        int i = maxUncrossedLines(nums1, nums2);
        System.out.println(i);
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1][length2];
        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        int x = nums2[0];
        for (int i = 1; i < dp.length; i++) {
            if (nums1[i] == x) {
                dp[i][0] = Math.max(dp[i - 1][0], 1);
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        x = nums1[0];
        for (int i = 1; i < dp[0].length; i++) {
            if (nums2[i] == x) {
                dp[0][i] = Math.max(dp[0][i - 1], 1);
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int v = nums1[i] == nums2[j] ? 1 : 0;
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i - 1][j - 1] + v, dp[i][j]);
            }
        }
        return dp[length1 - 1][length2 - 1];
    }
}
