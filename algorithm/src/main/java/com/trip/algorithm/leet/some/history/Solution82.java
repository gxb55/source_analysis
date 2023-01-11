package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/4/13  17:25
 * @description 删除排序链表中的重复元素
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * 通过次数243,021提交次数456,128
 */
public class Solution82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(4);
        ListNode head7 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        Solution82 solution82 = new Solution82();
        ListNode listNode = solution82.deleteDuplicates(head);
        listNode.print();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode();
        ListNode temp = result;
        while (head != null) {
            int val = head.val;
            ListNode next = head.next;
            boolean flag = false;
            while (next != null && val == next.val) {
                head = head.next;
                next = next.next;
                flag = true;
            }
            if (!flag) {
               // System.out.println(head.val);
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = head;
        return result.next;
    }
}
