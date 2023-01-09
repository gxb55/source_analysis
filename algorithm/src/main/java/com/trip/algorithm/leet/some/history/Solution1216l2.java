package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-16 20:11
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 通过次数295,821提交次数728,163
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1216l2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next =listNode1;
        ListNode listNode2= new ListNode(3);
        listNode1.next =listNode2;


      /*  ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode1.next =listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;*/
        Solution1216l2 solution1216l2 = new Solution1216l2();
        ListNode listNode5 = solution1216l2.removeNthFromEnd(listNode, 2);
        System.out.println(111);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int num=1;
        ListNode temp = head;
        while (temp.next!=null){
            num++;
            temp = temp.next;
        }
        if(num == 1){
            return null;
        }
        int i = num -n;


        if(i==0){
            head =head.next;
            return head;
        }
        temp = head;
        while (i>1){
            temp = temp.next;
            i--;
        }
        temp .next =temp.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}

