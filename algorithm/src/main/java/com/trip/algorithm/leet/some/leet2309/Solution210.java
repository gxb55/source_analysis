package com.trip.algorithm.leet.some.leet2309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年09月10日 18:57:00
 */
public class Solution210 {
    public static void main(String[] args) {
      /*  int numCourses = 7;
        int[][] prerequisites = {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};*/

        int numCourses = 3;
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] dp = new int[numCourses];
        for (int[] arr : prerequisites) {
            int x = arr[0];
            int y = arr[1];
            list.get(x).add(y);
            dp[x]++;
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dp.length; i++) {
            int i1 = dp[i];
            if (i1 == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer integer = queue.pollLast();
            res.add(integer);
            for (int i = 0; i < list.size(); i++) {
                List<Integer> temp = list.get(i);
                boolean remove = temp.remove(integer);
                if (remove&&temp.isEmpty()) {
                    queue.addFirst(i);
                }
            }
        }
        if (res.size() == dp.length) {
            int[] r = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                r[i] = res.get(i);
            }
            return r;
        }
        return new int[]{};
    }
}
