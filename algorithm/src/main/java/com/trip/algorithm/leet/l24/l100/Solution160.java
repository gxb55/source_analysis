package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        ListNode temp = headA;
        while (temp != null) {
            list1.add(temp);
            temp = temp.next;
        }
        ListNode temp1 = headB;
        while (temp1 != null) {
            list2.add(temp1);
            temp1 = temp1.next;
        }
        int l = list1.size() - 1;
        int r = list2.size() - 1;
        ListNode res = null;
        while (list1.get(l).val == list2.get(r).val) {
            res = list1.get(l);
            l--;
            r--;
            if (l < 0 || r < 0) {
                break;
            }
        }
        return res;
    }
}
