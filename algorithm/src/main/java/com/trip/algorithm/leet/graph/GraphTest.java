package com.trip.algorithm.leet.graph;

import java.util.*;

/**
 * @author Administrator
 */
public class GraphTest {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 1}, {1, 3, 4}, {1, 4, 2},
                /* {2, 1, 1}, {3, 1, 4}, {4, 1, 2},*/
                {2, 5, 1}, {2, 6, 4}, {2, 7, 2},
                {3, 2, 1}, {4, 3, 4}, {4, 7, 2},
                /*  {5, 2, 1}, {6, 2, 4}, {7, 2, 2},*/
        };
        Graph graph = createGraph(arr);
        System.out.println("");
        Node node = graph.getNodes().get(1);
        dfs(node);
        bfs(node);
        System.out.println("---------------");
        sortedTopology(graph);
    }

    /**
     * matrix
     * 0 from
     * 1 to
     * 2 value
     *
     * @param matrix
     * @return
     */
    public static Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] arr : matrix) {
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];
            if (!graph.getNodes().containsKey(from)) {
                graph.getNodes().put(from, new Node(from));
            }
            if (!graph.getNodes().containsKey(to)) {
                graph.getNodes().put(to, new Node(to));
            }
            Node fromNode = graph.getNodes().get(from);
            Node toNode = graph.getNodes().get(to);

            Edge edge = new Edge(fromNode, toNode, weight);
            fromNode.out++;
            toNode.in++;

            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

    /**
     * 宽度优先
     *
     * @param node
     */
    public static void bfs(Node node) {
        System.out.println("bfs begin");
        System.out.println();
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.value);
            poll.nexts.stream().forEach(x -> {
                queue.add(x);
            });
        }
    }

    /**
     * 深度优先
     *
     * @param node
     */
    public static void dfs(Node node) {
        System.out.println("dfs begin");
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            List<Node> nexts = pop.nexts;
            for (Node node1 : nexts) {
                if (!set.contains(node1)) {
                    System.out.println(node1.value);
                    set.add(node1);
                    stack.add(pop);
                    stack.add(node1);
                    break;
                }
            }
        }
    }

    /**
     * 图的拓扑排序
     *
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Integer, Node> nodes = graph.getNodes();
        Queue<Node> list = new LinkedList<>();
        for (Map.Entry<Integer, Node> nodeEntry : nodes.entrySet()) {
            if (nodeEntry.getValue().in == 0) {
                list.add(nodeEntry.getValue());
            }
        }

        while (!list.isEmpty()) {
            Node poll = list.poll();
            System.out.println(poll.value);
            poll.nexts.stream().peek(x -> x.in--).filter(x -> x.in == 0).forEach(x -> {
                list.add(x);
            });
        }
        return null;
    }
}
