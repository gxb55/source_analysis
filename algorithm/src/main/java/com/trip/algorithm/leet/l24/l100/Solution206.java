package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

public class Solution206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode();
        while (head != null) {
            ListNode head1 = head;
            head = head.next;

            ListNode tempNext = temp.next;
            temp.next = head1;
            head1.next = tempNext;
        }
        return temp.next;
    }
}
