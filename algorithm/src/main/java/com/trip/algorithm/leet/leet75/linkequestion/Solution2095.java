package com.trip.algorithm.leet.leet75.linkequestion;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年07月31日 22:48:00
 */
public class Solution2095 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2};
        ListNode listNode = ListNode.buildListNode(arr);
        ListNode.printNode(listNode);
        ListNode listNode1 = deleteMiddle(listNode);
        System.out.println("-----------");
        ListNode.printNode(listNode1);
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        } else if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowParent = null;
        do {
            fast = fast.next;
            fast = fast.next;
            slowParent = slow;
            slow = slow.next;
        } while (fast.next != null);
        ListNode next = slowParent.next;
        // 跳过了 slow
        slowParent.next=next.next;
        return head;
    }
}
