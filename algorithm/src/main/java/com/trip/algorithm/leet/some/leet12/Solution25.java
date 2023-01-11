package com.trip.algorithm.leet.some.leet12;


import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2022/12/29 16:50
 * @description 25. K 个一组翻转链表
 */
public class Solution25 {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode listNode1 = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 3;

        ListNode listNode = solution25.reverseKGroup(listNode1, k);
        ListNode.printNode(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode pre = new ListNode();
        ListNode result = pre;
        int len = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            len++;
            lenNode = lenNode.next;
        }
        int re = len / k;
        while (temp != null) {
            int t = k;
            ListNode cur = null;
            while (t > 0) {
                ListNode next = temp.next;

                temp.next = cur;
                cur = temp;

                temp = next;
                t--;
            }
            re--;
            result.next = cur;
            while (result.next != null) {
                result = result.next;
            }
            if (re == 0) {
                result.next = temp;
                break;
            }
        }
        return pre.next;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;

            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
