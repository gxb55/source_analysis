package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/22  16:00
 * @description 120
 */
public class Solution120 {
    public static void main(String[] args) {
//[[2],[3,4],[6,5,7],[4,1,8,3]]
        Solution120 solution120 = new Solution120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        int i = solution120.minimumTotal(list);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int x = triangle.size();
        int y = triangle.get(x - 1).size();

        int dp[][] = new int[x][y];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < i + 1; j++) {
                int last = i;
                if (j >= last) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) {
            min = Math.min(min, dp[x - 1][i]);
        }
        return min;
    }
}
