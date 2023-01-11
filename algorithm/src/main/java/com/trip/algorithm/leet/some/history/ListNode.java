package com.trip.algorithm.leet.some.history;

public class ListNode {
   public int val;
    public  ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
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
    public  void print() {
        if (this == null) {
            return;
        }
        ListNode temp = this;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
