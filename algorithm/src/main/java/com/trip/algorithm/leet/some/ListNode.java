package com.trip.algorithm.leet.some;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (Integer a : arr) {
            temp.next = new ListNode(a);
            temp = temp.next;
        }
        return listNode.next;
    }

    public static void printNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
