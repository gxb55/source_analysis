package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月14日 21:46:00
 */
public class Solution1466 {
    public static void main(String[] args) {
        Solution1466 solution1466 = new Solution1466();
       /* int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}; */

        int n = 5;
        int[][] connections = {{1,0},{1,2},{3,2},{3,4}};
        int i = solution1466.minReorder(n, connections);
        System.out.println(i);
    }


    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = buildGraph(n, connections);
        boolean[] vis = new boolean[n];
        process(list, vis, 0);
        return count;
    }

    private void process(List<List<Integer>> list, boolean[] vis, int index) {
        vis[index] = true;
        List<Integer> list1 = list.get(index);
        for (int i = 0; i < list1.size(); i++) {
            Integer cur = list1.get(i);
            if (vis[Math.abs(cur)]) {
                continue;
            }
            if (cur < 0) {
                count++;
            }
            process(list, vis, Math.abs(cur));
        }
    }

    private List<List<Integer>> buildGraph(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : connections) {
            int from = arr[0];
            int to = arr[1];
            // 指向我的是正的，说明可以到我

            graph.get(to).add(from);
            graph.get(from).add(-to);

        }
        return graph;

    }

    int count = 0;

}

