package com.trip.algorithm.leet.l24.l01;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(cur.val);
        while (cur.next != null) {
            if (!set.add(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
