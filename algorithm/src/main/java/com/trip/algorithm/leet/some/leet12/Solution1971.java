package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/19 10:25
 * @description Solution1971
 * 1971. 寻找图中是否存在路径
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * <p>
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * <p>
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * 输出：true
 * 解释：存在由顶点 0 到顶点 2 的路径:
 * - 0 → 1 → 2
 * - 0 → 2
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * 输出：false
 * 解释：不存在由顶点 0 到顶点 5 的路径.
 */
public class Solution1971 {
    public static void main(String[] args) {
        Solution1971 solution1971 = new Solution1971();
       /* int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 2;*/

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0, destination = 5;
        boolean b = solution1971.validPath(n, edges, source, destination);
        System.out.println(b);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int[] arr : edges) {
            merge(arr, dp);
        }
        return find(source, dp) == find(destination, dp);
    }

    private void merge(int[] arr, int[] dp) {
        int val = find(arr[0], dp);
        int val1 = find(arr[1], dp);
        dp[val] = val1;
    }

    private int find(int i, int[] dp) {
        while (dp[i] != i) {
            i = dp[i];
        }
        return i;
    }
}
