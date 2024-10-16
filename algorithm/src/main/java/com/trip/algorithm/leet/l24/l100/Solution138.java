package com.trip.algorithm.leet.l24.l100;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public static void main(String[] args) {
//head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;

        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        copyRandomList(node7);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Integer> nodeMap = new HashMap<>();
        Map<Integer, Node> map = new HashMap<>();
        Node pre = new Node(-1);
        Node cur = pre;
        Node temp = head;
        int index = 0;
        while (temp != null) {
            nodeMap.put(temp, index);
            temp = temp.next;
            index++;
        }
        index = 0;
        temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            cur.next = node;
            map.put(index, node);

            cur = cur.next;
            temp = temp.next;
            index++;
        }
        temp = head;
        cur = pre;
        while (temp != null) {
            Node random = temp.random;
            if (random != null) {
                Integer i1 = nodeMap.get(random);
                cur.next.random = map.get(i1);
            }
            cur = cur.next;
            temp = temp.next;
        }
        return pre.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}