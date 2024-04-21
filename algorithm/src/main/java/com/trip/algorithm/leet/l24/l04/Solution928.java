package com.trip.algorithm.leet.l24.l04;

import java.util.*;
import java.util.stream.Collectors;

public class Solution928 {
    public static void main(String[] args) {
        int[][] graph = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[] initial = {0, 1};
        Solution928 solution928 =new Solution928();
        int i = solution928.minMalwareSpread(graph, initial);
        System.out.println(i);
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        List<Integer> list = new ArrayList<>();
        for (int i : initial) {
            list.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = process(graph, list, -1);
        for (int i = 0; i < list.size(); i++) {
            Integer remove = list.remove(0);
            int process = process(graph, list, remove);
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

    private int process(int[][] graph, List<Integer> list, int index) {
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
                if (poll != index && i != index && !vis[i] && graph[poll][i] == 1) {
                    vis[i] = true;
                    linkedList.addLast(i);
                    count++;
                }
            }
        }
        return count;
    }
}
