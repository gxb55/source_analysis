package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年06月22日 10:09:00
 */
public class Solution16_19 {
    public static void main(String[] args) {
        Solution16_19 solution16_19 = new Solution16_19();
        int[][] arr = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] ints = solution16_19.pondSizes(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    int v = process(i, j, land, index);
                    index--;
                    list.add(v);
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int process(int i, int j, int[][] land, int index) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[i].length) {
            return 0;
        }
        if (land[i][j] != 0) {
            return 0;
        }
        land[i][j] = index;
        int t = process(i - 1, j, land, index) +
                process(i + 1, j, land, index) +
                process(i, j - 1, land, index) +
                process(i, j + 1, land, index) +
                process(i - 1, j - 1, land, index) +
                process(i + 1, j + 1, land, index) +
                process(i - 1, j + 1, land, index) +
                process(i + 1, j - 1, land, index)+1;
        return t;
    }
}
