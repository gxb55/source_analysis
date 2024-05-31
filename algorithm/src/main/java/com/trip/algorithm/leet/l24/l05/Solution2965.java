package com.trip.algorithm.leet.l24.l05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/5/31 16:54
 * @description TODO
 */
public class Solution2965 {
    public static void main(String[] args) {

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length;
        int sum = length * length;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            list.add(i);
        }
        int[] res = new int[2];
        for (int[] arr : grid) {
            for (int x : arr) {
                boolean remove = list.remove(Integer.valueOf(x));
                if (!remove) {
                    res[1] = x;
                }
            }
        }
        res[0] = list.get(0);
        return res;
    }
}
