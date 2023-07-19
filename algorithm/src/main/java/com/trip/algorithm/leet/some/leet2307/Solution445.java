package com.trip.algorithm.leet.some.leet2307;

import com.trip.algorithm.leet.some.codeThink.linkedlist.ListNode;

/**
 * @author xbguo
 * @createTime 2023年07月03日 21:36:00
 */
public class Solution445 {
    public static void main(String[] args) {
        Solution445 solution445 = new Solution445();
        int[] l1 = {7, 2, 4, 3}, l2 = {9, 6, 4};
        ListNode listNode = solution445.addTwoNumbers(ListNode.build(l1), ListNode.build(l2));
        ListNode.print(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        int cur = 0;
        while (temp != null) {
            temp = temp.next;
            cur++;
        }
        temp = l2;
        while (temp != null) {
            temp = temp.next;
            cur--;
        }
        if (cur > 0) {
            while (cur > 0) {
                ListNode t = new ListNode(0);
                t.next = l2;
                l2 = t;
                cur--;
            }
        } else {
            while (cur < 0) {
                ListNode t = new ListNode(0);
                t.next = l1;
                l1 = t;
                cur++;
            }
        }
        ListNode process = process(l1, l2);
        if (process.val > 9) {
            int i = process.val / 10;
            int i1 = process.val % 10;
            process.val = i1;
            ListNode t = new ListNode(i);
            t.next = process;
            return t;
        }
        return process;
    }

    private ListNode process(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val);
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        if (l1.next != null) {
            temp1 = l1.next;
        }
        if (l2.next != null) {
            temp2 = l2.next;
        }
        ListNode process = process(temp1, temp2);
        int i = process.val / 10;
        process.val = process.val % 10;
        ListNode listNode = new ListNode(l1.val + l2.val + i);
        listNode.next = process;
        return listNode;
    }
}
