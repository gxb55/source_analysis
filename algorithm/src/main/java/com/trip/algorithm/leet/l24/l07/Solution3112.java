package com.trip.algorithm.leet.l24.l07;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author xbguo
 * @date 2024/7/18 10:29
 */
public class Solution3112 {

    public static void main(String[] args) {
        /*int n = 3;
        int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
        int[] disappear = {1, 3, 5};*/

        int n = 5;
        int[][] edges = {{3,1,6},{1,4,4},{1,0,4},{3,3,4},{2,2,9},{2,4,3},{0,1,1},{3,2,3}};
        int[] disappear = {13,8,20,12,11};
      /*  int n = 2;
        int[][] edges = {{0, 1, 1}};
        int[] disappear = {1, 1};  */

       /* int n = 3;
        int[][] edges = {{2, 0, 9}, {1, 0, 5}, {2, 2, 4}, {0, 1, 10}, {1, 1, 10}, {1, 1, 10}, {2, 2, 10}, {1, 1, 10}};
        int[] disappear = {4, 13, 19};*/
        Solution3112 solution3112 = new Solution3112();
        int[] ints = solution3112.minimumTime1(n, edges, disappear);
        System.out.println(JSON.toJSONString(ints));
    }






    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] arr = new int[n];
        boolean[] vis = new boolean[n];
        int[][] graph = new int[n][n];
        for (int[] a : graph) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        for (int[] a : edges) {
            int x = a[0];
            int y = a[1];
            int z = a[2];
            if (z < graph[x][y]) {
                graph[x][y] = z;
            }
            if (z < graph[y][x]) {
                graph[y][x] = z;
            }
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        Arrays.fill(arr, Integer.MAX_VALUE);
        vis[0] = true;
        arr[0] = 0;
        int[] ints = graph[0];
        for (int i = 0; i < ints.length; i++) {
            int x = ints[i];
            if (x != Integer.MAX_VALUE && graph[0][i] < disappear[i]) {
                arr[i] = x;
            }
        }
        for (int i = 1; i < n; i++) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (vis[j] || arr[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (arr[j] < minVal && arr[j] < disappear[j]) {
                    minVal = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                continue;
            }
            vis[minIndex] = true;
            for (int j = 0; j < n; j++) {
                if (vis[j] || graph[minIndex][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (arr[j] > (arr[minIndex] + graph[minIndex][j]) && (arr[minIndex] + graph[minIndex][j]) < disappear[j]) {
                    arr[j] = (arr[minIndex] + graph[minIndex][j]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x == Integer.MAX_VALUE) {
                arr[i] = -1;
            }
        }
        return arr;
    }


        public int[] minimumTime1(int n, int[][] edges, int[] disappear) {
            List<int[]>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<int[]>();
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], length = edge[2];
                adj[u].add(new int[]{v, length});
                adj[v].add(new int[]{u, length});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{0, 0});
            int[] answer = new int[n];
            Arrays.fill(answer, -1);
            answer[0] = 0;
            while (!pq.isEmpty()) {
                int[] arr = pq.poll();
                // t是距离 ；u是点
                int t = arr[0], u = arr[1];
                if (t != answer[u]) {
                    continue;
                }
                for (int[] next : adj[u]) {
                    // v是点是u-v length是距离是 u-v的距离
                    int v = next[0], length = next[1];
                    if (t + length < disappear[v] && (answer[v] == -1 || t + length < answer[v])) {
                        pq.offer(new int[]{t + length, v});
                        answer[v] = t + length;
                    }
                }
            }
            return answer;
        }


}
