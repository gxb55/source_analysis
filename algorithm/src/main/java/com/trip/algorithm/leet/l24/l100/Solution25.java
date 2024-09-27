package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2024/9/27 16:40
 * head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */
public class Solution25 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 3;
        ListNode listNode1 = reverseKGroup(listNode, k);
        listNode1.print();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        ListNode pre1 = pre;
        ListNode temp = head;
        int t;
        while (temp != null) {
            t = 1;
            ListNode temp1 = temp;
            ListNode tempPre = new ListNode();
            tempPre.next = temp1;
            while (t < k && temp1 != null) {
                temp1 = temp1.next;
                t++;
            }
            boolean flag = false;
            if (temp1 != null) {
                ListNode next = temp1.next;
                temp1.next = null;
                temp = next;
                flag = true;
            } else {
                temp = null;
            }
            if (t == k&&flag) {
                tempPre = tempPre.next;
                while (tempPre != null) {
                    ListNode next1 = tempPre.next;

                    ListNode preNext = pre1.next;
                    pre1.next = tempPre;
                    tempPre.next = preNext;

                    tempPre = next1;
                }
                while (pre1.next != null) {
                    pre1 = pre1.next;
                }
            } else {
                pre1.next = tempPre.next;
            }


        }
        return pre.next;
    }
}
