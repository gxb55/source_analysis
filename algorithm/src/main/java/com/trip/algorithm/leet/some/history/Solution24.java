package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/6/13  18:48
 * @description 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 通过次数457,374提交次数644,728
 */
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] arr = {1, 2, 3, 4};
        ListNode listNode1 = ListNode.buildListNode(arr);
        ListNode listNode = solution24.swapPairs1(listNode1);
        listNode.print();
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;

            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;

            node1.next = node2.next;
            node2.next = node1;
            temp = node1;

        }
        return dummy.next;
    }
}
