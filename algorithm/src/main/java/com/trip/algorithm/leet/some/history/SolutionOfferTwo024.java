package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/28  19:03
 * @description 反转链表
 * 剑指 Offer II 024. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class SolutionOfferTwo024 {
    public static void main(String[] args) {
        SolutionOfferTwo024 solutionOfferTwo024 = new SolutionOfferTwo024();
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = solutionOfferTwo024.reverseList1(ListNode.buildListNode(arr));
        listNode.print();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = null;
        return doReverseNode(head,cur);
    }

    private ListNode doReverseNode(ListNode head, ListNode cur) {
        if (head == null ) {
            return cur;
        }
        ListNode next = head.next;
        head.next=cur;
        return doReverseNode(next,head);
    }
}
