package com.trip.algorithm.leet.some.codeThink.linkedlist;

/**
 * @author xbguo
 * @createTime 2022年11月05日 18:11:00
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class Solution203 {
    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        ListNode node = ListNode.build(new int[]{1,2,6,3,4,5,6});
        int val = 1;

        ListNode listNode = solution203.removeElements(node, val);
        ListNode.print(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode listNode = new ListNode();
        listNode.next = head;
        ListNode tempNode = listNode;
        while (tempNode.next != null) {
            ListNode next = tempNode.next;
            if (next.val == val) {
                tempNode.next = next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        return listNode.next;
    }
}
