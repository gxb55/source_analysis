package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/9/6 14:38
 * @description TODO
 */
public class Solution56 {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(arr);
        Arrays.stream(merge).forEach(x->{
            System.out.println(Arrays.toString(x));
        });
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> collect = Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        List<int[]> res = new ArrayList<>();
        int[] cur = null;
        for (int[] arr : collect) {
            if (cur == null) {
                cur = new int[2];
                cur[0] = arr[0];
                cur[1] = arr[1];
            } else {
                if (cur[1] >= arr[0]) {
                    cur[1] = Math.max(cur[1], arr[1]);
                } else {
                    res.add(new int[]{cur[0],cur[1]});
                    cur = new int[2];
                    cur[0] = arr[0];
                    cur[1] = arr[1];
                }
            }
        }
        res.add(new int[]{cur[0],cur[1]});
        int[][]  a=new int[res.size()][2];
        for (int i = 0; i < a.length; i++) {
            int[] ints = res.get(i);
            a[i]=ints;
        }
        return a;
    }
}
