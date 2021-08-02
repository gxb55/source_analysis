package com.trip.algorithm.zuo.day0613.map;

import java.util.*;

/**
 * 图的表示 点 边
 *
 * @author Administrator
 */
public class Graph {
    /**
     * 点集合
     */
    public HashMap<Integer, Node> nodes;
    /**
     * 边集合
     */
    public HashSet<Edge> edges;

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    /**
     * 基于我们设计的graph的宽度优先遍历
     * 使用队列先进先出
     *
     * @param node
     */
    public static void bfs(Node node) {
        //队列  先进先出
        Queue<Node> queue = new LinkedList<>();
        //set 防止环的情况 a b c a
        HashSet<Node> hashSet = new HashSet<>();
        queue.add(node);
        hashSet.add(node);
        while (!queue.isEmpty()) {
            Node pop = queue.poll();
            System.out.println(pop);
            for (int i = 0; i < pop.nexts.size(); i++) {
                if (!hashSet.contains(pop.nexts.get(i))) {
                    queue.add(pop.nexts.get(i));
                    hashSet.add(pop.nexts.get(i));
                }
            }
        }
    }

    /**
     * 深度优先原则借助于stack 先进后出
     */
    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> hashSet = new HashSet<>();
        stack.push(node);
        hashSet.add(node);
        System.out.println(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node cur : pop.nexts) {
                if (!hashSet.contains(cur)) {
                    System.out.println(cur);
                    stack.push(pop);
                    stack.push(cur);
                    hashSet.add(cur);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序，有向无循环
     *
     * @param graph
     * @return
     */
    public static List<Node> sortedToPology(Graph graph) {
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }

        List<Node> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            list.add(poll);
            for (Node cur : poll.nexts) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    queue.add(cur);
                }
            }
        }
        return list;
    }

    /**
     * 最小生成树 P算法，通过解锁点，解锁点对应的所有边，从边中选择权重最小的一个解锁点
     *
     * @param graph
     * @return
     */
    public static Set<Edge> primMST(Graph graph) {
        //边的权重从小到大排序 解锁的边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Edge_Compare());
        // 边的set集合 防止重复加入 解锁的边，防止重复加入
        Set<Edge> edgeSet = new HashSet<>();
        // 点的集合 解锁的点
        Set<Node> nodeSet = new HashSet<>();
        // 结果集 边的集合 不保证顺序
        Set<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            // 从图中找到一个点，把这个点和这个点边解锁变放入队列，后面是 点 边 点 边
            // 从解锁的边里面找到到达的点，判断到达的点是否被解锁
            nodeSet.add(node);
            for (Edge edge : node.edges) {
                if (!edgeSet.contains(edge)) {
                    edgeSet.add(edge);
                    priorityQueue.add(edge);
                }
            }
            while (!priorityQueue.isEmpty()) {
                // 所有边中权值最小的哪个
                Edge poll = priorityQueue.poll();
                Node to = poll.getTo();
                if (!nodeSet.contains(to)) {
                    nodeSet.add(to);
                    result.add(poll);
                    for (Edge edge : to.edges) {
                        // 这个边没有被处理过
                        if (!edgeSet.contains(edge)) {
                            priorityQueue.add(edge);
                        }
                    }
                }
            }
            // 防止森林
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        priorityQueue.add(11);
        priorityQueue.add(8);
        priorityQueue.add(5);
        priorityQueue.add(90);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}

