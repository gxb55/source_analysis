package com.trip.algorithm.codethink.linkedlist;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @auther: xbguo
 * @date: 2022/11/7 16:05
 * @description: TODO
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
       /* ListNode listNode1 = ListNode.buildListNode(new int[]{1,2,3,4,5});
        int n=2;*/

        ListNode listNode1 = ListNode.buildListNode(new int[]{1,2});
        int n = 2;
        ListNode listNode = solution19.removeNthFromEnd(listNode1, n);
        ListNode.printNode(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int i = len - n;
        temp = pre;
        while (i > 0) {
            i--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return pre.next;
    }
}
