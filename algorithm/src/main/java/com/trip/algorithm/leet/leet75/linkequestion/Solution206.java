package com.trip.algorithm.leet.leet75.linkequestion;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年08月01日 22:29:00
 */
public class Solution206 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4};
        ListNode listNode = ListNode.buildListNode(arr);
        ListNode.printNode(listNode);
        ListNode listNode1 = reverseList(listNode);
        System.out.println("--------");
        ListNode.printNode(listNode1);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode();
        ListNode temp=head;
        while (temp!=null){
            ListNode next = listNode.next;
            ListNode next1 = temp.next;
            listNode.next=temp;
            temp.next=next;

            temp=next1;
        }
        return listNode.next;
    }
}
