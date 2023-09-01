package com.trip.algorithm.leet.leet75.linkedlistproblem;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2023/9/1 18:52
 * @description TODO
 */
public class Solution2095 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode node = ListNode.buildListNode(arr);
        Solution2095 solution2095 = new Solution2095();
        ListNode node1 = solution2095.deleteMiddle(node);
        ListNode.printNode(node1);
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head.next;
        if(fast==null){
            return null;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
