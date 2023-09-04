package com.trip.algorithm.leet.leet75.linkedlistproblem;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2023/9/4 16:24
 */
public class Solution328 {
    public static void main(String[] args) {
        Solution328 solution328 = new Solution328();
        int[] arr = {1,2};
        ListNode node1 = ListNode.buildListNode(arr);

        ListNode node = solution328.oddEvenList(node1);
        ListNode.printNode(node);
    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode temp1 = null;
        ListNode temp2 = null;
        boolean flag = true;
        while (head != null) {
            ListNode next = head.next;
            if (flag) {
                if (head1 == null) {
                    head1 = head;
                    temp1 = head1;
                } else {
                    temp1.next = head;
                    temp1 = temp1.next;
                }
                temp1.next=null;
            } else {
                if (head2 == null) {
                    head2 = head;
                    temp2 = head2;
                } else {
                    temp2.next = head;
                    temp2 = temp2.next;
                }
                temp2.next=null;
            }
            head = next;
            flag = !flag;
        }
        temp1.next = head2;
        return head1;
    }
}
