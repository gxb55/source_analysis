package com.trip.algorithm.leet.some.leet2301;

import java.util.*;

/**
 * @author xbguo
 * @date 2023/1/25 10:07
 * @description 1632
 */
public class Solution1632 {
    public static void main(String[] args) {
        Solution1632 solution1632 = new Solution1632();
        // int[][] matrix = {{1, 2}, {3, 4}};
        // int[][] matrix = {{7,7},{7,7}};
        //  int[][] matrix = {{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
        // int[][] matrix = {{7,3,6},{1,4,5},{9,8,2}};
        int[][] matrix = {
                {-2, -35, -32, -5, -30, 33, -12},
                {7, 2, -43, 4, -49, 14, 17},
                {4, 23, -6, -15, -24, -17, 6},
                {-47, 20, 39, -26, 9, -44, 39},
                {-50, -47, 44, 43, -22, 33, -36},
                {-13, 34, 49, 24, 23, -2, -35},
                {-40, 43, -22, -19, -4, 23, -18}};
        int[][] ints = solution1632.matrixRankTransform(matrix);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((x, y) -> {
            return matrix[x[0]][x[1]] - matrix[y[0]][y[1]];
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(new int[]{i, j});
            }
        }
        // int 0 :下标到几了；1：当前数字是多少
        Map<Integer, int[]> xMap = new HashMap<>();
        Map<Integer, int[]> yMap = new HashMap<>();
        int[][] res = new int[xLen][yLen];
        int max1 = 0;
        while (!queue.isEmpty()) {
            LinkedList<int[]> list = new LinkedList<>();
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int val = matrix[x][y];
            list.add(poll);
            while (!queue.isEmpty() && val == matrix[queue.peek()[0]][queue.peek()[1]]) {
                list.add(queue.poll());
            }
            while (!list.isEmpty()) {
                poll = list.pollFirst();
                x = poll[0];
                y = poll[1];
                val = matrix[x][y];
                int[] intx = xMap.get(x);
                int[] inty = yMap.get(y);
                int cur;
                int[] arr;
                if (intx == null && inty == null) {
                    cur = 1;
                    arr = new int[]{cur, matrix[x][y]};
                } else if (intx != null && inty == null) {
                    cur = intx[1] == val ? intx[0] : intx[0] + 1;
                    arr = new int[]{cur, matrix[x][y]};
                } else if (intx == null && inty != null) {
                    cur = inty[1] == val ? inty[0] : inty[0] + 1;
                    arr = new int[]{cur, matrix[x][y]};
                } else {
                    int max = Math.max(inty[1], intx[1]);
                    if (max == inty[1] && max == intx[1] && val == max) {
                        cur = Math.max(intx[0], inty[0]);
                    } else if (val == inty[1]) {
                        cur = inty[0];
                    } else if (val == intx[1]) {
                        cur = intx[0];
                    } else {
                        cur = Math.max(intx[0], inty[0]) + 1;
                    }
                    arr = new int[]{cur, matrix[x][y]};
                }
                if (cur < max1&&list.size()!=1) {
                    list.addLast(poll);
                    continue;
                }
                max1 = Math.max(max1, cur);
                res[x][y] = cur;
                xMap.put(x, arr);
                yMap.put(y, arr);
            }
        }
        return res;
    }
}
