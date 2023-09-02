package com.trip.algorithm.leet.leet75.linkedlistproblem;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2023/9/1 17:25
 */
public class Solution206 {
    public static void main(String[] args) {

        int[] arr={1,2,3,4,5};
        ListNode node = ListNode.buildListNode(arr);
        ListNode node1 = reverseList(node);
        ListNode.printNode(node1);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = temp;
            temp = head;

            head = next;

        }
        return temp;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode temp=head;
        while (temp!=null){
            ListNode next = listNode.next;
            ListNode next1 = temp.next;

            listNode.next=temp;
            temp.next=next;

            temp=next1;
        }
        return listNode.next;
    }
}
