package com.trip.algorithm.leet.some.codeThink.linkedlist;

/**
 * @author xbguo
 * @createTime 2022年11月05日 19:25:00
 */
public class Solution206 {
    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = solution206.reverseList(ListNode.build(arr));
        ListNode.print(listNode);
    }

    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (head != null) {
            ListNode headNext = head.next;

            ListNode next = temp.next;

            head.next = next;
            temp.next = head;

            head = headNext;

        }
        return res.next;
    }
}
