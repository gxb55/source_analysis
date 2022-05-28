package com.trip.algorithm.zuo.trainingcamp3.class04;

/**
 * 双向链表节点结构和二叉树节点结构是一样的，如果你把last认为是left，next认为是next的话。
 * 给定一个搜索二叉树的头节点head，请转化成一条有序的双向链表，并返回链表的头节点。
 */
public class Code02_BSTtoDoubleLinkedList {
    public static void main(String[] args) {
        /**
         *             5
         *        2        9
         *       1 3     7  10
         *           4  6 8
         *
         */
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);
        Info process = process(head);
        print(process);
    }

    private static void print(Info process) {
        if (process != null && process.start != null) {
            Node temp = process.start;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.right;
            }
        }
    }

    /**
     * @param x 树节点，搜索二叉树，左边《根》右边
     * @return
     */
    public static Info process(Node x) {
        if (x == null) {
            return new Info(null, null);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        if (leftInfo.end != null) {
            leftInfo.end.right = x;
        }
        if (rightInfo.start != null) {
            rightInfo.start.left = x;
        }
        x.left = leftInfo.end;
        x.right = rightInfo.start;

        Node begin = leftInfo.start == null ? x : leftInfo.start;
        Node end = rightInfo.end == null ? x : rightInfo.end;
        return new Info(begin, end);
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public Node start;
        public Node end;

        public Info(Node start, Node end) {
            this.start = start;
            this.end = end;
        }
    }
}
