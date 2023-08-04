package com.trip.algorithm.leet.some.leet2307;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2023/7/31 09:51
 */
public class Solution143 {
    public static void main(String[] args) {
        // int[] res = new int[]{1, 2, 3, 4, 5};
        // int[]  res=new int[]{1,2,3,4};
        // int[]  res=new int[]{1,2};
        int[] res = new int[]{1, 2, 3, 4, 5, 6};
        ListNode node = ListNode.buildListNode(res);
        ListNode.printNode(node);
        reorderList1(node);
        System.out.println("----------------------");
        ListNode.printNode(node);
    }

    public static void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.addLast(temp);
            temp = temp.next;
        }
        int len = stack.size();
        if (len <= 2) {
            return;
        }
        int i = len / 2;
        // 偶数少交换一次
        int count = len % 2 == 0 ? i - 1 : i;
        ListNode pre = new ListNode();
        ListNode cur = head;
        pre.next = head;
        int index = 0;
        boolean flag = true;
        while (index < count) {
            if (flag) {
                ListNode next = cur.next;

                ListNode node = stack.pollLast();
                stack.peekLast().next = null;

                cur.next = node;
                node.next = next;
                cur = cur.next;
                index++;
            } else {
                cur = cur.next;
            }
            flag = !flag;

        }
        System.out.println("");
    }

    public static void reorderList1(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = null;
        do {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slowPre = slow;
            fast = fast.next;
            slow = slow.next;
        } while (fast != null);
        slowPre.next = null;
        // 1 2 3 4
        ListNode pre = new ListNode();

        ListNode temp = slow;
        while (temp != null) {
            ListNode next = temp.next;

            ListNode curNext = pre.next;

            pre.next = temp;
            temp.next = curNext;
            temp = next;
        }
        slow = pre.next;
        temp = head;
        while (slow != null && temp != null) {
            ListNode next = temp.next;
            ListNode next1 = slow.next;
            temp.next = slow;
            if (next != null) {
                slow.next = next;
            }
            slow = next1;
            temp = next;
        }
    }
}
