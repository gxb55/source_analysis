package com.trip.algorithm.leet.some.history;

import com.alibaba.fastjson.JSON;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-13 16:10
 */
public class Solution1113l1 {
    public static void main(String[] args) {
        Solution1113l1  solution1113l1 = new Solution1113l1();
        ListNode result1 = new ListNode(1);
        ListNode result2 = new ListNode(2);
        ListNode result3 = new ListNode(3);
        ListNode result4 = new ListNode(4);
        ListNode result5 = new ListNode(5);
        result1.next=result2;
        result2.next=result3;
        result3.next=result4;
        result4.next=result5;
        ListNode listNode = solution1113l1.oddEvenList(result1);
        System.out.println(JSON.toJSONString(listNode));
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * <p>
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     * <p>
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     * <p>
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode node = result;

        ListNode result1 = new ListNode();
        ListNode node1 = result1;

        ListNode temp = head;
        while (temp != null) {
            node.next = new ListNode(temp.val);
            temp = temp.next;
            node = node.next;
            if (temp != null) {
                node1.next =new ListNode(temp.val);
                temp = temp.next;
                node1 = node1.next;
            }
        }
        node.next=result1.next;
        return result.next;
    }
}
