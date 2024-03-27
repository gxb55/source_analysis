package com.trip.algorithm.leet.l24.l03;

import java.util.*;

public class Solution1976 {
    public static void main(String[] args) {
        Solution1976 solution1976 = new Solution1976();
        int n = 7;
        int[][] roads =
                {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int i = solution1976.countPaths1(n, roads);
        System.out.println(i);

    }

    public int countPaths1(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<int[]>();
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1], t = road[2];
            e[x].add(new int[]{y, t});
            e[y].add(new int[]{x, t});
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        dis[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            // 距离
            long t = arr[0];
            // 当前点的是那个点
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            for (int[] next : e[u]) {
                int v = next[0], w = next[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }
        }
        return ways[n - 1];

    }

    public int countPaths(int n, int[][] roads) {
        List<Line>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] arr : roads) {
            int x = arr[0];
            int y = arr[1];
            int v = arr[2];
            lists[x].add(new Line(x, y, v));
            lists[y].add(new Line(y, x, v));
        }
        LinkedList<Line> list = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int curVal = 0;
        process(0, lists, list, vis, curVal);
        return (int) count;
    }

    private void process(int cur, List<Line>[] lists, LinkedList<Line> list, boolean[] vis, int curVal) {
        if (cur == lists.length - 1) {
            //   System.out.println(list);
            if (min == -1) {
                min = curVal;
                count = 1;
            } else if (curVal == min) {
                count++;
            } else {
                if (curVal < min) {
                    min = curVal;
                    count = 1;
                }
            }
            count = count % 1000000007;
            return;
        }
        if (min != -1) {
            if (curVal > min) {
                return;
            }
        }
        if (vis[cur]) {
            return;
        }
        vis[cur] = true;
        List<Line> list1 = lists[cur];
        for (Line k : list1) {
            if (vis[k.end]) {
                continue;
            }
            list.addLast(k);
            process(k.end, lists, list, vis, curVal + k.val);
            list.pollLast();
        }
        vis[cur] = false;

    }

    int min = -1;
    long count = 0;

}

class Line {
    public int begin;
    public int end;
    public int val;

    public Line(int begin, int end, int val) {
        this.begin = begin;
        this.end = end;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                ", val=" + val +
                '}';
    }
}