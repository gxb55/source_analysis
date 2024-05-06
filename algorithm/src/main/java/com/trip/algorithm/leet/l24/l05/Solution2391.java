package com.trip.algorithm.leet.l24.l05;

public class Solution2391 {
    public static void main(String[] args) {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        Solution2391 solution2391 = new Solution2391();
        int i = solution2391.garbageCollection(garbage, travel);
        System.out.println(i);
    }

    /**
     * 符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃
     *
     * @param garbage
     * @param travel
     * @return
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int[][] dp = new int[garbage.length][3];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 0; i < garbage.length; i++) {
            dp[i] = new int[]{0, 0, 0};
            char[] charArray = garbage[i].toCharArray();
            for (Character c : charArray) {
                if (c == 'M') {
                    dp[i][0]++;
                    p1 = i;
                }
                if (c == 'P') {
                    dp[i][1]++;
                    p2 = i;
                }
                if (c == 'G') {
                    dp[i][2]++;
                    p3 = i;
                }
            }
        }
        for (int j = 0; j <= p1; j++) {
            int t = (j - 1) >= 0 ? travel[j - 1] : 0;
            sum1 = sum1 + dp[j][0] + t;
        }
        for (int j = 0; j <= p2; j++) {
            int t = (j - 1) >= 0 ? travel[j - 1] : 0;
            sum2 = sum2 + dp[j][1] + t;
        }
        for (int j = 0; j <= p3; j++) {
            int t = (j - 1) >= 0 ? travel[j - 1] : 0;
            sum3 = sum3 + dp[j][2] + t;
        }
        return sum2 + sum3 + sum1;
    }
}
