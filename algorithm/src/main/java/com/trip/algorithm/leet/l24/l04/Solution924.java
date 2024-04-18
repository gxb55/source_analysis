package com.trip.algorithm.leet.l24.l04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/4/17 10:34
 */
public class Solution924 {
    public static void main(String[] args) {
        int[][] graph = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] initial = {1 ,2};
        Solution924 solution924 =new Solution924();
        int i = solution924.minMalwareSpread(graph, initial);
        System.out.println(i);
    }

    //用 n × n 个邻接矩阵图 graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。
    public int minMalwareSpread(int[][] graph, int[] initial) {
        List<Integer> list = new ArrayList<>();
        for (int i : initial) {
            list.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = process(graph, list);
        for (int i = 0; i < list.size(); i++) {
            Integer remove = list.remove(0);
            int process = process(graph, list);
            map.put(remove, count - process);
            list.add(remove);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((x, y) -> {
            if (y.getValue().equals(x.getValue())) {
                return x.getKey() - y.getKey();
            } else {
                return y.getValue() - x.getValue();
            }
        }).collect(Collectors.toList());
        return collect.get(0).getKey();
    }

    private int process(int[][] graph, List<Integer> list) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        LinkedList<Integer> linkedList = new LinkedList<>();
        int count = 0;
        for (int i : list) {
            linkedList.add(i);
            vis[i] = true;
            count++;
        }
        while (!linkedList.isEmpty()) {
            Integer poll = linkedList.poll();
            for (int i = 0; i < graph[poll].length; i++) {
                if (!vis[i] && graph[poll][i] == 1) {
                    vis[i] = true;
                    linkedList.addLast(i);
                    count++;
                }
            }
        }
        return count;
    }
}
