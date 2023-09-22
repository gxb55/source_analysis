package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/15 09:59
 */
public class Solution_lcp_50 {
    public static void main(String[] args) {
        int[] gem = {0, 2, 5, 4};
        int[][] operations = {{3, 2}, {3, 2}, {1, 3}, {0, 2}, {3, 0}, {3, 1}, {0, 3}, {2, 1}, {3, 0}};
        int i = giveGem(gem, operations);
        System.out.println(i);
    }

    public static int giveGem(int[] gem, int[][] operations) {
        for (int[] t : operations) {
            int i = t[0];
            int j = t[1];
            int v = (int) Math.floor(gem[i] / 2.0);
            gem[i] = gem[i] - v;
            gem[j] = (int) (v + gem[j]);
        }
        int max = gem[0], min = gem[0];
        for (int x : gem) {
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        return max - min;
    }
}
