package com.trip.algorithm.leet.some.codeThink.linkedlist;

/**
 * @author xbguo
 * @createTime 2022年11月05日 19:43:00
 */
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = solution24.swapPairs(ListNode.build(arr));
        ListNode.print(listNode);
        System.out.println("===================");
        ListNode.print(solution24.swapPairs1(ListNode.build(arr)));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode tempNode = listNode;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;

            ListNode firstNode = head;
            ListNode secNode = head.next;

            secNode.next = firstNode;
            tempNode.next = secNode;
            tempNode = tempNode.next;
            tempNode = tempNode.next;
            head = next;
        }
        tempNode.next = head;
        return listNode.next;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode tempNode = listNode;
        int index;
        while (head != null) {
            ListNode listNode1 = new ListNode();
            index = 2;
            while (index > 0 && head != null) {
                ListNode next = head.next;

                ListNode next1 = listNode1.next;
                listNode1.next = head;
                head.next = next1;

                head = next;
                index--;
            }
            tempNode.next = listNode1.next;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
        }
        return listNode.next;
    }
}
