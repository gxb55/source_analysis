package com.trip.algorithm.leet.some.leet2307;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年07月30日 08:39:00
 */
public class Solution142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        } while (fast != null && fast != slow);
        if (fast == null) {
            return null;
        }
        // 从头再转一遍进去
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
