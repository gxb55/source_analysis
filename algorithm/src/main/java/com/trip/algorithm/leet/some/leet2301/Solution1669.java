package com.trip.algorithm.leet.some.leet2301;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2023/1/30 09:39
 * @description Solution1669
 * 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 *
 *
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 *
 * 提示：
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 * 通过次数24,896提交次数32,789
 */
public class Solution1669 {
    public static void main(String[] args) {
        Solution1669 solution1669 = new Solution1669();
       /* int[] list1 = {0, 1, 2, 3, 4, 5};
        int a = 0, b = 4;
        int[] list2 = {1000000, 1000001, 1000002};*/

        int[] list1 = {0,1,2,3,4,5,6};
        int a = 2, b = 5;
        int[] list2 = {1000000,1000001,1000002,1000003,1000004};
        ListNode listNode = solution1669.mergeInBetween(ListNode.buildListNode(list1), a, b, ListNode.buildListNode(list2));
        ListNode.printNode(listNode);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode();
        res.next = list1;
        ListNode temp = res;
        ListNode right = null;
        int index = -1;
        while (temp != null) {
            if (index == a - 1) {
                while (index < b) {
                    temp.next = temp.next.next;
                    index++;
                }
                right = temp.next;
                temp.next = null;
                break;
            } else {
                temp = temp.next;
            }
            index++;
        }
        temp.next = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = right;
        return res.next;
    }
}
