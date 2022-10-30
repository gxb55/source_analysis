package com.trip.algorithm.leet.some.leet2208;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年08月24日 22:18:00
 * <p>
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 通过次数338,107提交次数510,272
 */
public class Solution148 {
    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        int[] arr = {4, 2, 1, 3};
        ListNode node = ListNode.buildListNode(arr);
        ListNode node1 = solution148.sortList1(node);
        ListNode.printNode(node1);
    }

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.getNext();
        }
        list.sort(Comparator.comparingInt(ListNode::getVal));
        ListNode resultNode = new ListNode(-1);
        ListNode tempNode = resultNode;
        for (ListNode node : list) {
            node.setNext(null);
            tempNode.setNext(node);
            tempNode = node;
        }
        return resultNode.getNext();
    }


    public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        return process(head);
    }

    private ListNode process(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        ListNode result1 = process(head);
        ListNode result2 = process(next);

        ListNode result = new ListNode();
        ListNode temp = result;
        while (result1 != null && result2 != null) {
            if (result1.val < result2.val) {
                ListNode next1 = result1.next;
                temp.next = result1;
                result1 = next1;
            } else {
                ListNode next1 = result2.next;
                temp.next = result2;
                result2 = next1;
            }
            temp=temp.next;
        }
        while (result1 != null) {
            ListNode next1 = result1.next;
            temp.next = result1;
            result1 = next1;
            temp=temp.next;
        }
        while (result2 != null) {
            ListNode next1 = result2.next;
            temp.next = result2;
            result2 = next1;
            temp=temp.next;
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode buildListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            ListNode listNode = new ListNode();
            ListNode temp = listNode;
            for (Integer a : arr) {
                temp.next = new ListNode(a);
                temp = temp.next;
            }
            return listNode.next;
        }

        public static void printNode(ListNode node) {
            if (node == null) {
                return;
            }
            ListNode temp = node;
            while (temp != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
