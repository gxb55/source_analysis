package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution3111 {
    public static void main(String[] args) {
        int[][] points = {{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
        int w = 1;
        int i = minRectanglesToCoverPoints(points, w);
        System.out.println(i);
    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : points) {
            int i = arr[0];
            list.add(i);
        }
        list = list.stream().distinct().sorted((x, y) -> x - y).collect(Collectors.toList());
        if (w == 0) {
            return list.size();
        }
        int start = -1;
        int end = -1;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            if (i == 0) {
                start = v;
                end = start + w;
                count++;
            } else {
                if (v > end) {
                    start = v;
                    end = start + w;
                    count++;
                }
            }
        }
        return count;
    }
}
