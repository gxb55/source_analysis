package com.trip.algorithm.leet.some.Leet2308;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年08月06日 10:03:00
 */
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = solution24.swapPairs(ListNode.buildListNode(arr));
        ListNode.printNode(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode listNode1 = new ListNode();
        ListNode temp = listNode1;
        ListNode pre=null;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                ListNode next1 = head.next;
                temp.next = head;
                pre=temp;
                temp = temp.next;
                temp.next=null;
                head = next1;
            } else {
                ListNode next1 = head.next;

                pre.next=head;
                head.next=temp;

                pre=pre.next;
                head=next1;
            }
            flag=!flag;
        }
        return listNode1.next;
    }
}
