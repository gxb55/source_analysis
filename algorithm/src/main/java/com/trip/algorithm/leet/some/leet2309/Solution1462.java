package com.trip.algorithm.leet.some.leet2309;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/9/12 09:31
 */
public class Solution1462 {
    public static void main(String[] args) {
        Solution1462 solution1462 = new Solution1462();
        //  int numCourses = 2; int[][] prerequisites = {{1,0}}, queries = {{0,1},{1,0}};
        int numCourses = 2;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}}, queries = {{1, 0}, {1, 2}};
        List<Boolean> list = solution1462.checkIfPrerequisite(numCourses, prerequisites, queries);
        System.out.println(list);
    }

    /**
     * [ai, bi]
     * 想选 bi 课程，你 必须 先选 ai 课
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : prerequisites) {
            int a = arr[0];
            int b = arr[1];
            List<Integer> orDefault = map.getOrDefault(b, new ArrayList<>());
            orDefault.add(a);
            map.put(b, orDefault);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] arr : queries) {
            //其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
            int a = arr[0];
            int b = arr[1];
            LinkedList<Integer> list = new LinkedList<>();
            list.add(b);
            Set<Integer> set = new HashSet<>();
            boolean flag = false;
            while (!list.isEmpty()) {
                Integer integer = list.pollLast();
                if (!set.add(integer)) {
                    continue;
                }
                if (integer == a) {
                    flag = true;
                    break;
                }
                List<Integer> list1 = map.get(integer);
                if (list1 != null) {
                    for (Integer integer1 : list1) {
                        list.addFirst(integer1);
                    }
                }
            }
            res.add(flag);
        }
        return res;
    }

    public List<Boolean> checkIfPrerequisite1(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<Integer>();
        }
        int[] indgree = new int[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        /**
         * [ai, bi]
         * 想选 bi 课程，你 必须 先选 ai 课
         */
        for (int[] p : prerequisites) {
            ++indgree[p[1]];
            g[p[0]].add(p[1]);
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            //g[cur] 依赖cur的
            for (int ne : g[cur]) {
                isPre[cur][ne] = true;
                for (int i = 0; i < numCourses; ++i) {
                    isPre[i][ne] = isPre[i][ne] | isPre[i][cur];
                }
                --indgree[ne];
                if (indgree[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }
}

