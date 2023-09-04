package com.trip.algorithm.leet.leet75.linkedlistproblem;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2023/9/4 16:13
 */
public class Solution2130 {
    public static void main(String[] args) {
        Solution2130 solution2130 =new Solution2130();
        //int[] arr={5,4,2,1};
      //  int[] arr={4,2,2,3};
        int[] arr={1,100000};
        ListNode node = ListNode.buildListNode(arr);
        int i = solution2130.pairSum(node);
        System.out.println(i);
    }

    public int pairSum(ListNode head) {
        int max = 0;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        ListNode temp = null;
        while (next != null) {
            ListNode next1 = next.next;

            next.next = temp;
            temp = next;

            next = next1;
        }
        while (temp != null) {
            int val = temp.val;
            int val1 = head.val;
            max = Math.max(val1 + val, max);
            temp = temp.next;
            head = head.next;
        }
        return max;
    }
}
