package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        boolean f = (size % 2 == 0);
        int l = size / 2;
        int r = size / 2;
        if (f) {
            l = l - 1;
        }
        while (l >= 0 && r < size) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
}
