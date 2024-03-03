package com.trip.algorithm.leet.l24.l03;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2368 {
    public static void main(String[] args) {
        Solution2368 solution2368 = new Solution2368();
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};
        int i = solution2368.reachableNodes1(n, edges, restricted);
        System.out.println(i);
    }

    public int reachableNodes1(int n, int[][] edges, int[] restricted) {
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        boolean[] isrestricted = new boolean[n];
        for (int x : restricted) {
            isrestricted[x] = true;
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            map[x].add(y);
            map[y].add(x);
        }
        Set<Integer> set = new HashSet<>();
        process(map, set, 0, -1, isrestricted);
        return set.size();
    }

    private void process(List<Integer>[] map, Set<Integer> set, int cur, int parent, boolean[] isrestricted) {
        set.add(cur);
        List<Integer> list = map[cur];
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int x : list) {
            if (x != parent && !isrestricted[x]) {
                process(map, set, x, cur, isrestricted);
            }
        }
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = Arrays.stream(restricted).boxed().collect(Collectors.toList());
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            put(map, x, y);
            put(map, y, x);
        }
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> curList = new LinkedList<>();
        curList.add(0);
        while (!curList.isEmpty()) {
            int size = curList.size();
            while (size > 0) {
                Integer i = curList.pollFirst();
                set.add(i);
                List<Integer> list1 = map.get(i);
                if (list1 != null && !list1.isEmpty()) {
                    for (int a : list1) {
                        if (set.contains(a) || list.contains(a)) {
                            continue;
                        }
                        curList.addLast(a);
                    }
                }
                size--;
            }
        }
        return set.size();
    }

    private void put(Map<Integer, List<Integer>> map, int x, int y) {
        List<Integer> orDefault = map.getOrDefault(x, new ArrayList<>());
        orDefault.add(y);
        map.put(x, orDefault);
    }
}
