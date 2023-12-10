package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.List;

public class Solution1466_V1 {
    public static void main(String[] args) {

        /*int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};*/

        int n = 5;
        int[][] connections = {{1,0},{1,2},{3,2},{3,4}};
        Solution1466_V1 solution1466V1 = new Solution1466_V1();
        int i = solution1466V1.minReorder(n, connections);
        System.out.println(i);
    }

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] arr : connections) {
            int x = arr[0];
            int y = arr[1];
            g[x].add(y);
            g[y].add(-x);
        }
        return process(0, -1, g);
    }

    private int process(int cur, int parent, List<Integer>[] g) {
        int sum = 0;
        List<Integer> list = g[cur];
        for (int i : list) {
            if (Math.abs(i) != parent) {
                if (i < 0) {
                    sum += process(Math.abs(i), cur, g);
                } else {
                    sum += process(Math.abs(i), cur, g) + 1;
                }
            }
        }
        return sum;
    }
}
