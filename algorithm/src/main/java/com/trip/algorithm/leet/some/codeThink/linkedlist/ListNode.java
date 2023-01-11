package com.trip.algorithm.leet.some.codeThink.linkedlist;

/**
 * @author xbguo
 * @createTime 2022年11月05日 18:12:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode build(int[] ints) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < ints.length; i++) {
            int cur = ints[i];
            temp.next = new ListNode(cur);
            temp = temp.next;
        }
        return head.next;
    }
}
