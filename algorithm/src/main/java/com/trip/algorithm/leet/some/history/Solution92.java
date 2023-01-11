package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/6/16  17:05
 * @description 92
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * 通过次数304,856提交次数550,472
 */
public class Solution92 {
    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        int[] head = {1, 2, 3, 4, 5};
        int left = 2, right = 4;
        ListNode listNode1 = ListNode.buildListNode(head);
        ListNode listNode = solution92.reverseBetween(listNode1, left, right);
        listNode.print();

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode leftNode = new ListNode(-1);
        ListNode leftPre = null;
        ListNode rightPre = null;
        int l=1;
        int r=1;
        while (temp != null) {
            if (l == left) {
                break;
            }
            r++;
            l++;
            leftPre = temp;
            temp = temp.next;
        }
        boolean flag =false;
        int index=1;
        while (temp != null) {
            if(flag){
                rightPre.next=temp;
                break;
            }
            if (r == right) {
                flag=true;
            }
            r++;
            ListNode next = temp.next;
            if(index==1){
                rightPre=temp;
            }
            temp.next=leftNode.next;
            leftNode.next=temp;
            temp=next;
            index++;
        }
        if (leftPre == null) {
            return leftNode.next;
        } else {
            leftPre.next = leftNode.next;
            return head;
        }

    }
}
