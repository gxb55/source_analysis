package com.trip.algorithm.leet.l24.l03;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution310 {
    public static void main(String[] args) {
       /* int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};*/
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        Solution310 solution310 = new Solution310();
        List<Integer> minHeightTrees = solution310.findMinHeightTrees(n, edges);
        System.out.println(JSON.toJSONString(minHeightTrees));

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(0);
            return list;
        }
        List<Integer>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] arr : edges) {
            int x = arr[0];
            int y = arr[1];
            map[x].add(y);
            map[y].add(x);
            degree[x]++;
            degree[y]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 度为1的集合
        for (int i = 0; i < degree.length; i++) {
            int i1 = degree[i];
            if (i1 == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.clear();
            while (size > 0) {
                Integer poll = queue.poll();
                list.add(poll);
                List<Integer> list1 = map[poll];
                for (int x : list1) {
                    degree[x]--;
                    if (degree[x] == 1) {
                        queue.addLast(x);
                    }
                }
                size--;
            }
        }
        list.sort(Comparator.comparingInt(x -> x));
        return list;
    }
}
