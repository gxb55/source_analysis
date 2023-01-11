package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/29  19:14
 * @description 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * 通过次数214,215提交次数513,022
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution61 {
    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        int[] arr = {1,2,3,4,5};
        ListNode listNode = ListNode.buildListNode(arr);
        ListNode listNode1 = solution61.rotateRight(listNode, 2);
        listNode1.print();
        //[4,5,1,2,3]
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int index = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            index++;
        }
        temp.next = head;
        ListNode result = head;
        k = k % index;
        for (int i = 1; i < index - k; i++) {
            result = result.next;
        }
        ListNode next = result.next;
        result.next = null;
        return next;
    }
}
