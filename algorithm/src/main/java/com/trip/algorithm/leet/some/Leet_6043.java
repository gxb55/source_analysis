package com.trip.algorithm.leet.some;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年05月15日 21:22:00
 */
public class Leet_6043 {
    public static void main(String[] args) {
        Leet_6043 leet_6043 = new Leet_6043();
       // int[][] rectangles = {{1,2},{2,3},{2,5}}, points = {{2,1},{1,4}};
      //  int[][] rectangles = {{1,1},{2,2},{3,3}}, points = {{1,3},{1,1}};
        int[][] rectangles = {{3,6},{2,8},{5,3}}, points = {{1,3},{1,1}};

         Arrays.stream(rectangles).sorted((x, y) -> {
            boolean flag = (x[0] - y[0]) >= 0 && (x[1] - y[0]) >= 0;
            return flag ? 1 : -1;
        }).forEach(x->{
            System.out.println(Arrays.toString(x));
        });

        int[] ints = leet_6043.countRectangles(rectangles,points);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        List<int[]> collect = Arrays.stream(rectangles).sorted((x, y) -> {
            boolean flag = (x[0] - y[0]) >= 0 && (x[1] - y[0]) >= 0;
            return flag ? 1 : -1;
        }).collect(Collectors.toList());
        for (int j = 0; j < points.length; j++) {
            int x = points[j][0];
            int y = points[j][1];
            for (int[] arr : rectangles) {
                int x1 = arr[0];
                int y1 = arr[1];
                if (x <= x1 && y <= y1) {
                    result[j]++;
                }
            }
        }
        return result;
    }
}
