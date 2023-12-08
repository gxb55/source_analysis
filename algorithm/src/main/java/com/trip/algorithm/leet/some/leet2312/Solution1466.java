package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/12/7 10:17
 * @description TODO
 */
public class Solution1466 {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        Solution1466 solution1466 = new Solution1466();
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


    private List<int[]>[] g;

    public int minReorder1(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[]{b, 1});
            g[b].add(new int[]{a, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int a, int fa) {
        int ans = 0;
        for (int[] e : g[a]) {
            int b = e[0], c = e[1];
            if (b != fa) {
                ans += c + dfs(b, a);
            }
        }
        return ans;
    }
}