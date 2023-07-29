package com.trip.algorithm.leet.some.leet2307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/7/18 16:47
 */
public class Solution1851 {
    public static void main(String[] args) {
        Solution1851 solution1851 = new Solution1851();
       /* int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};*/

        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
        int[] queries = {2,19,5,22};
        int[] ints = solution1851.minInterval(intervals, queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        // 按照左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 下标0代表值是多少；下标1,代表原来下标多少，用于赋值
        int[][] dp = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            dp[i][0] = queries[i];
            dp[i][1] = i;
        }
        Arrays.sort(dp, Comparator.comparingInt(o -> o[0]));
        // 按照长度来排序，
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));
        int[] res = new int[queries.length];
        Arrays.fill(res,-1);
        int index = 0;
        int len = intervals.length;
        for (int i = 0; i < queries.length; i++) {
            int curVal = dp[i][0];
            int curIndex = dp[i][1];
            // index小于总长度，并且 当前的值大于intervals的左端点
            while (index < len && intervals[index][0] <= curVal) {
                // 右端点，长度
                queue.add(new int[]{intervals[index][1], intervals[index][1] - intervals[index][0] + 1,intervals[index][0]});
                index++;
            }
            // 当前节点不为空，当前节点长度最小，如果当前节点符合则下面赋值，如果当前节点不符合，则抛弃直到找到符合的节点
            while (!queue.isEmpty() && curVal > queue.peek()[0]) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                res[curIndex] = queue.peek()[1];
            }
        }
        return res;
    }


    public int[] minInterval1(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        //要对queries数组排序，下标会改变，此操作是为了保存查询值与下标之间的关系
        int[][] qs = new int[m][0];
        for (int i = 0; i < m; i++) {
            qs[i] = new int[]{queries[i], i};
        }
        // 按照左端点排队
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        //队内元素[区间长度，区间右端点]，队首为长度最小的区间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        for (int[] q : qs) {
            //当前区间右端点大于查询条件，入队
            while (i < n && intervals[i][0] <= q[0]) {
                int x = intervals[i][0], y = intervals[i][1];
                pq.offer(new int[]{y - x + 1, y});
                i++;
            }
            //右端点小于查询点，即虽长度最小但不能满足条件,也不可能再满足后面点更大的条件
            while (!pq.isEmpty() && pq.peek()[1] < q[0]) {
                pq.poll();
            }
            //当前区间能满足查询条件，那么长度就是最短即答案
            if (!pq.isEmpty()) {
                ans[q[1]] = pq.peek()[0];
            }
        }
        return ans;
    }
}

class Node1851 {
    public int begin;
    public int end;
    public int val;

    public Node1851(int begin, int end, int val) {
        this.begin = begin;
        this.end = end;
        this.val = val;
    }
}
