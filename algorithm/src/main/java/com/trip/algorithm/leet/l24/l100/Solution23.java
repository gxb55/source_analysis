package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2024/10/15 19:16
 */
public class Solution23 {


    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode node : lists) {
            res = merge(res, node);
        }
        return res;
    }

    private ListNode merge(ListNode res, ListNode node) {
        if (res == null) {
            return node;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (res != null && node != null) {
            if (res.val < node.val) {
                temp.next = res;
                res = res.next;
            } else {
                temp.next = node;
                node = node.next;
            }
            temp = temp.next;
        }
        while (res != null) {
            temp.next = res;
            res = res.next;
            temp = temp.next;
        }
        while (node != null) {
            temp.next = node;
            node = node.next;
            temp = temp.next;
        }
        return head.next;
    }
}
