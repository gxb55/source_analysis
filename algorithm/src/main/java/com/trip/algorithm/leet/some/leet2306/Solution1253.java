package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/29 10:21
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 */
public class Solution1253 {
    public static void main(String[] args) {
       /* int upper = 2, lower = 1;
        int[] colsum = {1, 1, 1};*/
/*
        int upper = 2, lower = 3;
        int[] colsum = {2,2,1,1};   */

     /*   int upper = 5, lower = 5;
        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1}; */

        int upper = 4, lower = 7;
        int[] colsum = {2, 1, 2, 2, 1, 1, 1};
        List<List<Integer>> list = reconstructMatrix(upper, lower, colsum);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int len = colsum.length;
        int[][] dp = new int[2][len];
        for (int i = 0; i < colsum.length; i++) {
            int val = colsum[i];
            if (val == 2) {
                dp[0][i] = 1;
                dp[1][i] = 1;
                upper--;
                lower--;
            }
            if (upper < 0 || lower < 0) {
                return new ArrayList<>();
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            int val = colsum[i];
            if (val == 1 && upper > 0) {
                dp[0][i] = 1;
                upper--;
            } else if (val == 1 && lower > 0) {
                dp[1][i] = 1;
                lower--;
            } else if (val == 0 || val == 2) {
            } else {
                return new ArrayList<>();
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dp[0]).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(dp[1]).boxed().collect(Collectors.toList()));
        return list;
    }
}
