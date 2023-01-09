package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/24  11:02
 * @description 剑指 Offer II 026. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 */
public class SolutionOfferTwo026 {
    public static void main(String[] args) {
        ListNode listNode = getListNode();
        SolutionOfferTwo026 solutionOfferTwo026 = new SolutionOfferTwo026();
        solutionOfferTwo026.reorderList(listNode);
        print(listNode);
    }

    private static ListNode getListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        return listNode1;
    }

    private static void print(ListNode listNode) {
        System.out.println("----------------------------");
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode left = head;
        ListNode right = getMidNode(head);
        ListNode result = mergeNode(left, right);
        head = result;
    }

    private ListNode mergeNode(ListNode left, ListNode right) {
        ListNode result = new ListNode();
        ListNode cur = result;
        boolean flag = true;
        while (left != null || right != null) {
            if (flag) {
                ListNode leftNext = left.next;
                cur.next = left;
                cur = cur.next;
                left = leftNext;
            } else {
                ListNode rightNext = right.next;
                cur.next = right;
                cur = cur.next;
                right = rightNext;
            }
            flag = !flag;
        }
        return result.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        ListNode cur = null;
        while (next != null) {
            ListNode next1 = next.next;

            next.next = cur;
            cur = next;

            next = next1;
        }
        return cur;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
