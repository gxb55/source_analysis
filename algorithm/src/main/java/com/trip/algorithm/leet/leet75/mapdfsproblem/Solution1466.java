package com.trip.algorithm.leet.leet75.mapdfsproblem;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年08月14日 21:46:00
 */
public class Solution1466 {
    public static void main(String[] args) {

    }

    public int minReorder(int n, int[][] connections) {
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        vis[0] = true;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Map<Integer, Node1466> map = new HashMap<>();
        for (int[] arr : connections) {
            int begin = arr[0];
            int end = arr[1];
            Node1466 beginNode = map.getOrDefault(begin, new Node1466(begin));
            Node1466 endNode = map.getOrDefault(begin, new Node1466(end));
            Line1466 line1 = new Line1466(beginNode, endNode);
            // 当前节点指向外面的
            beginNode.outMap.put(end, line1);
            // 指向当前节点的
            endNode.intMap.put(begin, line1);
        }
        int cur = 0;
        // 将所有指向的节点移除
        process(map, vis, list, cur);
        List<Integer> curList =new ArrayList<>();
        curList.add(0);
        while (!list.isEmpty()){
            List<Integer> tempList =new ArrayList<>();
            for (Integer v:curList){
                Node1466 node1466 = map.get(v);
                Map<Integer, Line1466> outMap = map.get(v).outMap;
                Set<Integer> set = outMap.keySet();

            }
        }
        return 1;
    }

    private void process(Map<Integer, Node1466> map, boolean[] vis, List<Integer> list, int cur) {
        Node1466 node1466 = map.get(cur);
        node1466.intMap.values().stream().forEach(x -> {
            vis[x.begin.val] = true;
            list.remove(Integer.valueOf(x.begin.val));
            process(map,vis,list,x.begin.val);
        });
    }
}

class Node1466 {
    public int val;
    public Map<Integer, Line1466> outMap;
    public Map<Integer, Line1466> intMap;

    public Node1466(int val) {
        this.val = val;
        this.outMap = new HashMap<>();
        this.intMap = new HashMap<>();
    }
}

class Line1466 {
    public Node1466 begin;
    public Node1466 end;

    public Line1466(Node1466 begin, Node1466 end) {
        this.begin = begin;
        this.end = end;
    }
}
