package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/20  20:01
 * @description TODO
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 通过次数799,238提交次数1,198,204
 */
public class Solution21 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = {1, 5, 6, 7};
        ListNode node1 = getListNode(arr);
        ListNode node = getListNode(arr1);
        System.out.println(node);
        Solution21 solution21 = new Solution21();
        //  ListNode listNode = solution21.mergeTwoLists(node1, node);
        ListNode listNode = solution21.mergeTwoLists1(node1, node);
        print(listNode);
    }

    private static ListNode getListNode(int[] arr) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return node.next;
    }

    private static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            ListNode next2 = temp2.next;
            ListNode next1 = temp1.next;
            if (temp1.val >= temp2.val) {
                cur.next = temp2;
                temp2 = next2;
            } else if (temp1.val < temp2.val) {
                cur.next = temp1;
                temp1 = next1;
            }
            cur = cur.next;
        }
        if (temp1 != null) {
            cur.next = temp1;
        }
        if (temp2 != null) {
            cur.next = temp2;
        }
        return result.next;
    }


    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        doMergeTwoLists(list1, list2, cur);
        return result.next;
    }

    private void doMergeTwoLists(ListNode list1, ListNode list2, ListNode cur) {
        if (list1 == null && list2 != null) {
            cur.next = list2;
            return;
        }
        if (list1 != null && list2 == null) {
            cur.next = list1;
            return;
        }
        if (list1.val >= list2.val) {
            cur.next = list2;
            list2 = list2.next;
        } else {
            cur.next = list1;
            list1 = list1.next;
        }
        cur = cur.next;
        doMergeTwoLists(list1, list2, cur);
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
