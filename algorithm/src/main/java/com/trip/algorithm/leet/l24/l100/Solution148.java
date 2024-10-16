package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.List;

public class Solution148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        List<Integer> li = new ArrayList<>();

        while (head != null) {
            li.add(head.val);
            head = head.next;
        }
        li.sort((x, y) -> x - y);
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int i = 0; i < li.size(); i++) {
            cur.next = new ListNode(li.get(i));
            cur = cur.next;
        }
        return cur.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

