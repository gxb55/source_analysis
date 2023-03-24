package com.trip.algorithm.leet.some.leet2303;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年03月15日 21:32:00
 * 输入：n = 4, roads = {{0,1},{0,3},{1,2},{1,3}}
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 * <p>
 * 输入：n = 8, roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 */
public class Solution1615 {
    public static void main(String[] args) {
       /* int n = 4;
        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}};*/

       /* int n = 5;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};*/

        int n = 8;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};


        int i = maximalNetworkRank(n, roads);
        System.out.println(i);
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length<=0){
            return 0;
        }
        Map<Node1, Integer> map = new HashMap<>();
        Map<Integer, Node1> node1Map = new HashMap<>();
        List<Line1> list = new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            Node1 begin = node1Map.getOrDefault(road[0], new Node1(road[0]));
            Node1 end = node1Map.getOrDefault(road[1], new Node1(road[1]));
            list.add(new Line1(begin, end));
            list.add(new Line1(end, begin));
            Integer integer = map.get(begin);
            if (integer != null) {
                map.put(begin, integer + 1);
            } else {
                map.put(begin, 1);
            }
            integer = map.get(end);
            if (integer != null) {
                map.put(end, integer + 1);
            } else {
                map.put(end, 1);
            }
            node1Map.put(begin.val, begin);
            node1Map.put(end.val, end);
        }
        List<Map.Entry<Node1, Integer>> collect = map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).collect(Collectors.toList());
        Node1 key = collect.get(0).getKey();
        int max = 0;
        Node1 key1 = null;
        for (Map.Entry<Node1, Integer> entry : collect) {
            if (entry.getKey() != key) {
                key1 = entry.getKey();
                int t = map.get(key) + entry.getValue();
                if (list.contains(new Line1(key1, key))) {
                    t--;
                }
                max = Math.max(max, t);
            }
        }

        return max;
    }
}

class Node1 {
    public int val;

    public Node1(int val) {
        this.val = val;
    }
}

class Line1 {
    public Node1 begin;
    public Node1 end;

    public Line1(Node1 begin, Node1 end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line1 line1 = (Line1) o;
        return Objects.equals(begin, line1.begin) && Objects.equals(end, line1.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }
}