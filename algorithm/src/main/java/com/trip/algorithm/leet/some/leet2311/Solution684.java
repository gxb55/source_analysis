package com.trip.algorithm.leet.some.leet2311;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年11月12日 21:11:00
 */
public class Solution684 {
    public static void main(String[] args) {
        //  int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
      //  int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
          int[][] edges = {{2,7},{7,8},{3,6},{2,5},{6,8},{4,8},{2,8},{1,8},{7,10},{3,9}};
        Solution684 solution684 = new Solution684();
        int[] res = solution684.findRedundantConnection1(edges);
        System.out.println(Arrays.toString(res));
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<String> list1 = new ArrayList<>();
        for (int[] arr : edges) {
            int x = arr[0];
            int y = arr[1];
            list1.add(x + "-" + y);
            List<Integer> orDefault = map.getOrDefault(x, new ArrayList<>());
            orDefault.add(y);
            map.put(x, orDefault);
            List<Integer> orDefault1 = map.getOrDefault(y, new ArrayList<>());
            orDefault1.add(x);
            map.put(y, orDefault1);
            set.add(x);
            set.add(y);
        }
        List<Integer> list = new ArrayList<>();
        Set<String> strSet = new HashSet<>();
        for (int i : set) {
            list.clear();
            list.add(i);
            boolean process = process(i, map, list, strSet);
            if (process) {
                break;
            }
        }
        Integer i = list.get(list.size() - 1);
        while (!list.get(0).equals(i)) {
            list.remove(0);
        }
        list.remove(0);
        List<String> resList = new ArrayList<>();
        for (int j = 0; j < list.size() - 1; j++) {
            Integer x = list.get(j);
            Integer y = list.get(j + 1);
            resList.add(x + "-" + y);
            resList.add(y + "-" + x);
        }
        Integer last = list.get(list.size() - 1);
        Integer first = list.get(0);
        resList.add(last + "-" + first);
        resList.add(first + "-" + last);

        for (int j = list1.size() - 1; j >= 0; j--) {
            String s = list1.get(j);
            if (resList.contains(s)) {
                String[] split = s.split("-");
                return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
            }
        }
        return null;
    }

    private boolean process(int val, Map<Integer, List<Integer>> map, List<Integer> list, Set<String> strSet) {

        List<Integer> curList = map.get(val);
        if (curList == null || curList.size() == 0) {
            return false;
        }
        for (int x : curList) {
            String str = val + "-" + x;
            String str1 = x + "-" + val;
            if (strSet.contains(str) || strSet.contains(str1)) {
                continue;
            }
            strSet.add(str);
            strSet.add(str1);
            if (list.contains(x)) {
                list.add(x);
                return true;
            }
            list.add(x);
            boolean process = process(x, map, list, strSet);
            if (process) {
                return true;
            }
            list.remove(list.size() - 1);
            strSet.remove(str);
        }
        return false;
    }

    public int[] findRedundantConnection1(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] x : edges) {
            if (findParent(parent, x[0]) == findParent(parent, x[1])) {
                return x;
            } else {
                union(parent, x[0], x[1]);
            }
        }
        return edges[0];
    }

    private void union(int[] parent, int x, int y) {
        parent[findParent(parent,x)] = findParent(parent,y);
    }

    private int findParent(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = findParent(parent, parent[index]);
        }
        return parent[index];
    }

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union1(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union1(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
