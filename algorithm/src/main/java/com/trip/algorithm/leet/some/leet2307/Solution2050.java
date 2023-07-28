package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xbguo
 * @date 2023/7/28 14:41
 */
public class Solution2050 {
    public static void main(String[] args) {
       /* int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};
        int[] time = {3, 2, 5}; */

      /*  int n = 5;
        int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};
        int[] time = {1,2,3,4,5}; */

        int n = 9;
        int[][] relations = {{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},{4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}};
        int[] time = {9,5,9,5,8,7,7,8,4};
        Solution2050 solution2050 = new Solution2050();
        int i = solution2050.minimumTime(n, relations, time);
        System.out.println(i);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, Node2050> map = new HashMap<>();
        for (int i = 0; i < relations.length; i++) {
            int x = relations[i][0];
            int y = relations[i][1];
            Node2050 xNode = map.getOrDefault(x, new Node2050(x));
            Node2050 yNode = map.getOrDefault(y, new Node2050(y));

            xNode.out = xNode.out + 1;
            yNode.in = yNode.in + 1;
            xNode.list.add(new Line2050(xNode, yNode));
            map.put(x, xNode);
            map.put(y, yNode);
        }
        int res = 0;
        if(map.isEmpty()){
            Optional<Integer> max = Arrays.stream(time).boxed().max(Comparator.comparing(x -> x));
            return max.get();
        }
        List<Integer> list = new ArrayList<>();
        while (!map.isEmpty()) {
            int cur = 0;
            list.clear();
            for (Map.Entry<Integer, Node2050> entry : map.entrySet()) {
                // 没有人指向他，他可以先学
                if (entry.getValue().in == 0) {
                    list.add(entry.getKey());
                    cur = Math.max(cur, time[entry.getKey() - 1]);
                }
            }
            for (int x : list) {
                Node2050 value = map.get(x);
                // 释放他指向的点
                value.list.forEach(z -> z.endNode.in = z.endNode.in - 1);
                map.remove(x);
            }
            res += cur;
        }
        return res;
    }
}

class Node2050 {
    /**
     * 指向当前节点的
     */
    public Integer in;
    /**
     * 当前节点指出去的
     */
    public Integer out;
    public Integer val;
    public List<Line2050> list;

    public Node2050(Integer val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.list = new ArrayList<>();
    }
}

class Line2050 {
    public Node2050 beginNode;
    public Node2050 endNode;

    public Line2050(Node2050 beginNode, Node2050 endNode) {
        this.beginNode = beginNode;
        this.endNode = endNode;
    }

    public Line2050() {
    }
}
