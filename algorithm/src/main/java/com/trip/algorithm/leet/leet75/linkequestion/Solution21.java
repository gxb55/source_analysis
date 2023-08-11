package com.trip.algorithm.leet.leet75.linkequestion;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @createTime 2023年08月05日 10:02:00
 */
public class Solution21 {
    public static void main(String[] args) {

       int[] l1 = {1,2,4,7}; int[] l2 = {1,3,4,5,6};
        ListNode listNode = mergeTwoLists(ListNode.buildListNode(l1),ListNode.buildListNode(l2));
        ListNode.printNode(listNode);
    }

    /**
     * 降序
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                cur.next=list1;
                list1=list1.next;
            }else if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        while (list1!=null){
            cur.next=list1;
            list1=list1.next;
            cur=cur.next;
        }
        while (list2!=null){
            cur.next=list2;
            list2=list2.next;
            cur=cur.next;
        }
        // 单调栈
        return pre.next;
    }
}
