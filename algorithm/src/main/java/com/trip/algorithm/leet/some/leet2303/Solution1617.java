package com.trip.algorithm.leet.some.leet2303;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年03月13日 22:27:00
 */
public class Solution1617 {
    public static void main(String[] args) {

    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Node> list = new LinkedList<>();
        List<Line> lines = new LinkedList<>();
        for (int[] arr : edges) {
            Node node1 = new Node(arr[0]);
            Node node2 = new Node(arr[1]);
            list.add(node1);
            list.add(node2);
            lines.add(new Line(node2, node1));
            lines.add(new Line(node1, node2));
        }
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRes(lines,i+1);
        }
        return arr;
    }

    private int getRes(List<Line> lines, int len) {
        List<Node> list = new ArrayList<>();
        //process(lines,len,list);
        return 0;
    }
}

class Node {
    int val;

    public Node(int val) {
        this.val = val;
    }
}

class Line {
    Node begin;
    Node end;

    public Line(Node begin, Node end) {
        this.begin = begin;
        this.end = end;
    }
}

class Graph {
    List<Line> list;
    List<Node> nodes;
}
