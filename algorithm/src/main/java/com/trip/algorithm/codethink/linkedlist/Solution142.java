package com.trip.algorithm.codethink.linkedlist;

import com.trip.study.leetcode.history.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: xbguo
 * @date: 2022/11/7 16:44
 * @description: Solution142
 */
public class Solution142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        int index = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            } else {
                map.put(temp, index);
                index++;
                temp = temp.next;
            }
        }
        return null;
    }
}
