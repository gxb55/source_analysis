package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2024/9/27 16:15
 * @description head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Solution24 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        ListNode listNode = swapPairs(ListNode.buildListNode(arr));
        listNode.print();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();

        ListNode pre1 = pre;
        ListNode temp = head;
        boolean flag = true;
        while (temp != null) {
            if (flag) {
                pre1.next = temp;
                temp = temp.next;
                pre1.next.next=null;
            } else {
                ListNode next = temp.next;

                ListNode next1 = pre1.next;

                temp.next=next1;
                pre1.next=temp;

                temp = next;

                pre1 = pre1.next;
                pre1 = pre1.next;
            }

            flag = !flag;
        }
        return pre.next;
    }
}
