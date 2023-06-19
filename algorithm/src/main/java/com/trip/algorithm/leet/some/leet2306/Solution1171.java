package com.trip.algorithm.leet.some.leet2306;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/6/12 14:06
 */
public class Solution1171 {
    public static void main(String[] args) {
        //int[] head = {1,2,-3,3,1};
      //  int[] head = {1,2,3,-3,4};
        int[] head = {1,2,3,-3,-2};
        ListNode node1 = ListNode.buildListNode(head);
        ListNode node = removeZeroSumSublists(node1);
        ListNode.printNode(node);
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (temp.next != null) {
            sum = sum + temp.next.val;
            map.put(sum, temp.next);
            temp = temp.next;
        }
        sum = 0;
        temp = new ListNode(0);
        temp.next = head;
        ListNode node = temp;
        while (node != null) {
            sum = sum + node.val;
            if (map.containsKey(sum)) {
                node.next = map.get(sum).next;
            }
            node = node.next;
        }
        return temp.next;
    }
}
