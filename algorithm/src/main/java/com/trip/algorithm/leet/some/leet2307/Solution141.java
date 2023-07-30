package com.trip.algorithm.leet.some.leet2307;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年07月30日 08:32:00
 */
public class Solution141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);
        if (fast == null) {
            return false;
        }
        return true;
    }
}
