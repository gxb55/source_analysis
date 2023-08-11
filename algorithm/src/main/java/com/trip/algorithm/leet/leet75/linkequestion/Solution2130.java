package com.trip.algorithm.leet.leet75.linkequestion;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @createTime 2023年07月31日 23:10:00
 */
public class Solution2130 {
    public static void main(String[] args) {
        int[] arr=new int[]{5,4,2,1};
        ListNode listNode = ListNode.buildListNode(arr);
       // ListNode.printNode(listNode);
        int i = pairSum(listNode);
        System.out.println(i);
    }

    public static int pairSum(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            deque.addLast(temp);
            temp = next;
        }
        int count = deque.size();
        temp = head;
        int index = 0;
        int res = Integer.MIN_VALUE;
        while (index < count) {
            int val = deque.pollLast().val;
            int val1 = temp.val;
            res = Math.max(res, val1 + val);
            temp = temp.next;
            index++;
        }
        return res;
    }
}
