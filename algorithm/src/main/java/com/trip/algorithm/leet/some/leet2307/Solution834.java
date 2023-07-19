package com.trip.algorithm.leet.some.leet2307;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年07月16日 12:36:00
 */
public class Solution834 {
    public static void main(String[] args) {
        Solution834 solution834 = new Solution834();
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] ints = solution834.sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, Node834> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            Node834 xNode = map.getOrDefault(x, new Node834(x));
            Node834 yNode = map.getOrDefault(y, new Node834(y));
            Line834 lineX = new Line834(xNode, yNode);
            Line834 lineY = new Line834(yNode, xNode);
            xNode.list.add(lineX);
            yNode.list.add(lineY);
            map.put(x, xNode);
            map.put(y, yNode);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Node834 node834 = map.get(i);
            if (node834 == null) {
                res[i] = 0;
            } else {
                res[i] = getRes(node834);
            }
        }
        return res;
    }

    private int getRes(Node834 node834) {
        if (node834 == null || node834.list == null || node834.list.size() == 0) {
            return 0;
        }
        int cur = 1;
        int res = 0;
        Set<String> vis = new HashSet<>();
        Queue<List<Node834>> queue = new LinkedList<>();
        queue.add(Arrays.asList(node834));
        while (!queue.isEmpty()) {
            List<Node834> tempList = new ArrayList<>();
            List<Node834> poll = queue.poll();
            List<Line834> collect = poll.stream().map(x -> x.list).flatMap(x -> x.stream())
                    .filter(x -> !vis.contains(x.beginNode.val + "_" + x.endNode.val))
                    .filter(x -> !vis.contains(x.endNode.val + "_" + x.beginNode.val)).collect(Collectors.toList());

            for (int j = 0; j < collect.size(); j++) {
                Line834 line834 = collect.get(j);
                res += cur;
                tempList.add(line834.endNode);
                vis.add(line834.beginNode.val + "_" + line834.endNode.val);
                vis.add(line834.endNode.val + "_" + line834.beginNode.val);
            }
            if (tempList.size() > 0) {
                queue.add(tempList);
            }
            cur++;
        }
        return res;
    }
}

class Node834 {
    public int val;
    public List<Line834> list;

    public Node834() {
    }

    public Node834(int val) {
        this.val = val;
        this.list = new ArrayList<>();
    }
}

class Line834 {
    public Node834 beginNode;
    public Node834 endNode;

    public Line834(Node834 beginNode, Node834 endNode) {
        this.beginNode = beginNode;
        this.endNode = endNode;
    }

    public Line834() {
    }
}
