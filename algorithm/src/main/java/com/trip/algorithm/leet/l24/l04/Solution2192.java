package com.trip.algorithm.leet.l24.l04;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2192 {
    public static void main(String[] args) {
        Solution2192 solution2192 = new Solution2192();
        int n = 8;
        int[][] edgeList = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        List<List<Integer>> ancestors = solution2192.getAncestors(n,edgeList);
        ancestors.stream().forEach(x -> System.out.println(x));
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 谁指向我
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            map.get(to).add(from);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resultList.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(i);
            if (list.isEmpty()) {
                continue;
            }

            Arrays.fill(vis, false);
            LinkedList<Integer> tempList = new LinkedList<>(list);
            Set<Integer> set = new HashSet<>();
            while (!tempList.isEmpty()) {
                Integer i1 = tempList.pollFirst();
                if (!vis[i1]) {
                    set.add(i1);
                    List<Integer> list1 = map.get(i1);
                    list1.stream().forEach(x -> tempList.addLast(x));
                    vis[i1] = true;
                }
            }
            resultList.get(i).addAll(set.stream().sorted((x,y)->x-y).collect(Collectors.toList()));
        }
        return resultList;
    }
}
