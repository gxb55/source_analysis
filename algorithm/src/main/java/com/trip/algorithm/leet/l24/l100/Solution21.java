package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

public class Solution21 {
    public static void main(String[] args) {
        ListNode listNode1 =ListNode.buildListNode(new int[]{1,2,4});
        ListNode listNode2 =ListNode.buildListNode(new int[]{1,3,4});
        ListNode listNode = mergeTwoLists(listNode1, listNode2);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while (list1 != null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return head.next;
    }
}
