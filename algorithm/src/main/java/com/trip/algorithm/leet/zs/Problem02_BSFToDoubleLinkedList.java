package com.trip.algorithm.leet.zs;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年07月02日 20:06:00
 */
public class Problem02_BSFToDoubleLinkedList {
    public static void main(String[] args) {

    }

    public static Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return new Info();
        }
        Info process = process(treeNode.getLeft());
        Info process1 = process(treeNode.getRight());
        Node node = new Node(treeNode.getVal());
        node.pre = process.end;
        if (process.end != null) {
            process.end.next = node;
        }
        node.next = process1.begin;
        if (process1.begin != null) {
            process1.begin.pre = node;
        }
        return new Info(process.begin == null ? node : process.begin, process1.end == null ? node : process1.end);
    }

    static class Info {
        private Node begin;
        private Node end;

        public Info() {
        }

        public Info(Node begin, Node end) {
            this.begin = begin;
            this.end = end;
        }
    }

    static class Node {
        private Node pre;
        private Node next;
        private Integer val;

        public Node(Integer val) {
            this.val = val;
        }

        public Node() {
        }
    }
}
