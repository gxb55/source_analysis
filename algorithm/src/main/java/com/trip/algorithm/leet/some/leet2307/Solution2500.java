package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/7/27 17:23
 */
public class Solution2500 {
    public static void main(String[] args) {

    }

    public int deleteGreatestValue(int[][] grid) {
        int length = grid[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        int res = 0;
        int index = 0;
        while (index < length) {
            int cur = 0;
            for (int i = 0; i < grid.length; i++) {
                cur = Math.max(cur, grid[i][index]);
            }
            res += cur;
        }
        return res;

    }
}
