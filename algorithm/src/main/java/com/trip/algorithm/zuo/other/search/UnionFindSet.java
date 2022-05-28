package com.trip.algorithm.zuo.other.search;

import java.util.*;

/**
 * 并查集
 */
public class UnionFindSet {
    static class Node<V> {
        private V v;

        public Node(V v) {
            this.v = v;
        }
    }

    private Map<Node, Node> fatherMap = new HashMap<>();
    private Map<Node, Integer> sizeMap = new HashMap<>();

    public UnionFindSet(List<Node> list) {
        fatherMap.clear();
        sizeMap.clear();
        for (Node node : list) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public boolean isSameSet(Node a, Node b) throws Exception {
        return findHead(a) == findHead(b);
    }

    private Node findHead(Node b) throws Exception {
        if (!fatherMap.containsKey(b)) {
            throw new Exception(b + "没有初始化");
        }
        Stack<Node> stack = new Stack<>();
        Node cur = b;
        while (fatherMap.get(cur) != cur) {
            stack.push(cur);
            cur = fatherMap.get(cur);
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            fatherMap.put(pop, cur);
        }
        return cur;
    }

    public void union(Node a, Node b) throws Exception {
        boolean sameSet = isSameSet(a, b);
        if (sameSet) {
            return;
        } else {
            Integer aSize = sizeMap.get(a);
            Integer bSize = sizeMap.get(b);
            if (aSize > bSize) {
                fatherMap.put(b, a);
                sizeMap.put(a, aSize + bSize);
                sizeMap.remove(b);
            } else {
                fatherMap.put(a, b);
                sizeMap.put(b, aSize + bSize);
                sizeMap.remove(a);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Node> list = new ArrayList<>();
        Node node = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        Node node5 = new Node(1);
        Node node6 = new Node(1);
        Node node7 = new Node(1);
        Node node8 = new Node(1);
        Node node9 = new Node(1);
        Node node10 = new Node(1);
        list.add(node);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);
        list.add(node8);
        list.add(node9);
        list.add(node10);

        UnionFindSet unionFindSet = new UnionFindSet(list);
        boolean sameSet = unionFindSet.isSameSet(node, node2);
        System.out.println(sameSet);
        unionFindSet.union(node, node2);
        System.out.println(unionFindSet.isSameSet(node, node2));
        unionFindSet.union(node3, node2);
    }
}
