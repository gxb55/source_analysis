package com.trip.algorithm.leet.l24.l09;

import com.trip.algorithm.leet.some.history.ListNode;

public class Solution2181 {
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode listNode = ListNode.buildListNode(arr);
        ListNode listNode1 = mergeNodes(listNode);
        ListNode.printNode(listNode1);
    }

    public static ListNode mergeNodes(ListNode head) {

        ListNode temp = head;
        int last = 0;
        while (temp.next != null) {
            ListNode next = temp.next;
            if (next.val == 0) {
                next.val=last;
                last=0;
                temp = next;
            } else {
                temp.next = next.next;
                last = last + next.val;
            }
        }
        return head.next;
    }
}
