package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年06月12日 17:29:00
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * 通过次数154,709提交次数244,478
 */
public class Solution86 {
    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
       /* int[] head = {3, 4, 3, 2, 5, 2};
        int x = 3;*/

        int[] head = {2,1};
        int x = 2;
        ListNode listNode = ListNode.buildListNode(head);
        ListNode partition = solution86.partition(listNode, x);
        ListNode.printNode(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode listNodeMin = new ListNode(0);
        ListNode listNodeMax = new ListNode(0);
        ListNode temp1 = listNodeMin;
        ListNode temp2 = listNodeMax;
        while (head != null) {
            if (head.val < x) {
                temp1.next = head;
                temp1 = temp1.next;
                head = head.next;
                temp1.next = null;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
                head = head.next;
                temp2.next = null;
            }
        }

        temp1.next = listNodeMax.next;
        return listNodeMin.next;
    }
}
