package com.trip.algorithm.leet.some.leet12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/12/13 14:57
 * @description Solution1691
 */
public class Solution1691 {
    public static void main(String[] args) {
        Solution1691 solution1691 = new Solution1691();
     //   int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        int[][] cuboids = {{38,25,45},{76,35,3}};
        int i = solution1691.maxHeight(cuboids);
        System.out.println(i);
    }

    public int maxHeight(int[][] cuboids) {
        for (int[] arr : cuboids) {
            Arrays.sort(arr);
        }
        List<int[]> collect = Arrays.stream(cuboids).sorted((x, y) -> {
            if (x[0] - y[0] >= 0 && x[1] - y[1] >= 0 && x[2] -y[2] >= 0) {
                return -1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());
        List<List<int[]>> list = new ArrayList<>();
        int[] last = collect.get(0);
        List<int[]> list1 = new ArrayList<>();
        list1.add(last);
        for (int i = 1; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if (last[0] >= ints[0] && last[1] >= ints[1] && last[2] >= ints[2]) {
                list1.add(ints);
            } else {
                if (list1.size() >= 2) {
                    list.add(list1);
                }
                list1 = new ArrayList<>();
            }
            last = ints;
        }
        list.add(list1);
        int res = 0;
        for (List<int[]> list2 : list) {
            int sum = 0;
            for (int[] t : list2) {
                sum += Math.max(Math.max(t[0], t[1]), t[2]);
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    private boolean check(int[] y, int[] x) {
        boolean b = y[0] - x[0] >= 0 && y[1] - x[1] >= 0 && y[2] - x[2] >= 0;
        boolean b3 = y[0] - x[0] >= 0 && y[1] - x[2] >= 0 && y[2] - x[1] >= 0;
        boolean b1 = y[0] - x[1] >= 0 && y[1] - x[2] >= 0 && y[2] - x[0] >= 0;
        boolean b4 = y[0] - x[1] >= 0 && y[1] - x[0] >= 0 && y[2] - x[2] >= 0;
        boolean b2 = y[0] - x[2] >= 0 && y[1] - x[0] >= 0 && y[2] - x[1] >= 0;
        boolean b5 = y[0] - x[2] >= 0 && y[1] - x[1] >= 0 && y[2] - x[0] >= 0;
        return b || b1 || b2 || b3 || b4 || b5;
    }
}
