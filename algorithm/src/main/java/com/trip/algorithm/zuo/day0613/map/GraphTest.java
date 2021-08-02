package com.trip.algorithm.zuo.day0613.map;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GraphTest {
    public static void main(String[] args) {
        // graph_Bfs_Dfs();
        // primMST();
        Graph graph = initGraph();
        Set<Edge> edgeSet = KruskalMST(graph);
        for (Edge edge : edgeSet) {
            System.out.println(edge);
        }
    }

    /**
     * P方法最小生成树
     */
    private static void primMST() {
        Graph graph = initGraph();
        Set<Edge> edgeSet = Graph.primMST(graph);
        for (Edge edge : edgeSet) {
            System.out.println(edge);
        }
    }

    private static Graph initGraph() {
        Integer[][] arr = {{1, 1, 2}, {1, 2, 1}, {2, 1, 3}, {2, 3, 1}, {3, 3, 4}, {3, 4, 3}, {4, 2, 4}, {4, 4, 2},
                {5, 5, 2}, {5, 2, 5}, {6, 1, 5}, {6, 5, 1}, {7, 3, 5}, {7, 5, 3}, {8, 5, 4}, {8, 4, 4}};
        Graph graph = GraphGenerator.createGraph(arr);
        return graph;
    }

    /**
     * K 算法生成最小生成树，依赖并查集
     * 核心，所有的边，按照权重从小到大去找，
     * 所有的点构建并查集，如果一个边的两个点不是同一类则将他们放在一起，作为一类。
     * 所有的边不重复的，按照权重依次放入到set集合中去，放入的时候依赖于点之间的关系
     * @param graph
     * @return
     */
    public static Set<Edge> KruskalMST(Graph graph) {
        // 初始化并查集
        Code04_KrusKal.UnionFind unionFind = new Code04_KrusKal.UnionFind();
        unionFind.makeSets(graph.nodes.values());
        // 初始化优先级队列
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Edge_Compare());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        // 结果集
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            if (!unionFind.isSameSet(poll.from, poll.to)) {
                result.add(poll);
                unionFind.union(poll.from, poll.to);
            }
        }
        return result;
    }

    /**
     * 图的便利
     * 宽度优先
     * 深度游先
     */
    private static void graph_Bfs_Dfs() {
        Integer[][] arr = {{1, 1, 2}, {1, 2, 1}, {1, 2, 3}, {1, 3, 4}, {1, 1, 5}, {1, 5, 3}, {1, 3, 6}};
        Graph graph = GraphGenerator.createGraph(arr);
        // 宽度优先遍历 1 2 5 3 4 6 借助于队列 先进先出
        Graph.bfs(graph.nodes.get(1));
        // 深度优先遍历 借助于栈先进后出，找到一个相邻边就结束
        Graph.dfs(graph.nodes.get(1));
    }
}
