package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/9 10:03
 */
public class Solution2699 {
    public static void main(String[] args) {
        Solution2699 solution2699 = new Solution2699();
      /*  int n = 5;
        int[][] edges = {{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}};
        int source = 0, destination = 1, target = 5;*/

       /* int n = 3;
        int[][] edges = {{0,1,-1},{0,2,5}};
        int source = 0, destination = 2, target = 6;*/
/*
        int n = 4;
        int[][] edges = {{1,0,4},{1,2,3},{2,3,5},{0,3,-1}};
        int source = 0, destination = 2, target = 6;*/

        int n = 4;
        int[][] edges = {{0,1,-1},{1,2,-1},{3,1,-1},{3,0,2},{0,2,5}};
        int source = 2, destination = 3, target = 8;

        int[][] ints = solution2699.modifiedGraphEdges(n, edges, source, destination, target);
        for (int[] a:ints){
            System.out.println(Arrays.toString(a));
        }

    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        Map<Integer, Node> map = new HashMap<>();
        for (int[] arr : edges) {
            int i = arr[0];
            int j = arr[1];
            int k = arr[2];
            if (!map.containsKey(i)) {
                map.put(i, new Node(i));
            }
            if (!map.containsKey(j)) {
                map.put(j, new Node(j));
            }
            Node node = map.get(i);
            Node node1 = map.get(j);
            node.list.add(new Line(node, node1, k));
            node1.list.add(new Line(node1, node, k));
        }
        List<Line> list = new ArrayList<>();
        List<List<Line>> res = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        vis[0]=true;
        process(map, vis, source, destination, list, res);
        if (res.size() == 0) {
            return new int[][]{};
        }
        List<int[]> result = new ArrayList<>();
        for (List<Line> list1 : res) {
            int sum = 0;
            List<int[]> unValList = new ArrayList<>();
            List<int[]> valList = new ArrayList<>();
            for (Line l : list1) {
                if (l.val != -1) {
                    sum = sum + l.val;
                    valList.add(new int[]{l.beginNode.val, l.endNode.val, l.val});
                } else {
                    unValList.add(new int[]{l.beginNode.val, l.endNode.val, 1});
                }
            }
            if (sum + unValList.size() <= target&&unValList.size()!=0) {
                int k = target - (sum + unValList.size());
                unValList.get(unValList.size() - 1)[2] = k + 1;
                valList.addAll(unValList);
                if (result.size() == 0) {
                    result = valList;
                } else if (valList.size() < result.size()) {
                    result = valList;
                }
            }
        }
        if (result.size() == 0) {
            return new int[][]{};
        }
        Map<String, int[]> map1 = new HashMap<>();
        for (int[] a : result) {
            map1.put(a[0] + "-" + a[1], a);
        }
        for (int[] a : edges) {
            String v = a[0] + "-" + a[1];
            String v1 = a[1] + "-" + a[0];
            if (map1.containsKey(v) && map1.get(v)[2] != a[2]) {
                a[2] = map1.get(v)[2];
            }else if(map1.containsKey(v1) && map1.get(v1)[2] != a[2]){
                a[2] = map1.get(v1)[2];
            }else if(a[2]==-1){
                a[2]=1;
            }
        }
        return edges;
    }

    private void process(Map<Integer, Node> map, boolean[] vis, int source, int destination, List<Line> list, List<List<Line>> res) {
        if (source == destination) {
            res.add(new ArrayList<>(list));
            return;
        }
        Node node = map.get(source);
        if (node == null || node.list == null) {
            return;
        }
        List<Line> list1 = node.list;
        for (Line line : list1) {
            if (vis[line.endNode.val]) {
                continue;
            }
            vis[line.endNode.val] = true;
            list.add(line);
            process(map, vis, line.endNode.val, destination, list, res);
            vis[line.endNode.val] = false;
            list.remove(list.size() - 1);
        }

    }
}

class Node {
    public int val;
    public List<Line> list;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        list = new ArrayList<>();
    }
}

class Line {
    public Node beginNode;
    public Node endNode;
    public int val;

    public Line(Node beginNode, Node endNode, int val) {
        this.beginNode = beginNode;
        this.endNode = endNode;
        this.val = val;
    }

    public Line(Node beginNode, Node endNode) {
        this.beginNode = beginNode;
        this.endNode = endNode;
    }

    @Override
    public String toString() {
        return "Line{" +
                "beginNode=" + beginNode.val +
                ", endNode=" + endNode.val +
                '}';
    }
}
