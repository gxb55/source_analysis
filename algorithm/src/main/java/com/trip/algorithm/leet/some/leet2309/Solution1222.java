package com.trip.algorithm.leet.some.leet2309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/9/14 09:35
 */
public class Solution1222 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dp = new int[8][8];
        for (int[] arr : queens) {
            dp[arr[0]][arr[1]] = 8;
        }
        int curX = king[0];
        int curY = king[1];
        List<List<Integer>> list = new ArrayList<>();
        int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
        for (int[] t : step) {
            int x = curX;
            int y = curY;
            int i = t[0];
            int j = t[1];
            while (true) {
                x = x + i;
                y = y + j;
                if (x >= 0 && y >= 0 && x < 8 && y < 8) {
                    if (dp[x][y] == 8) {
                        list.add(Arrays.asList(x, y));
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
