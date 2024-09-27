package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

/**
 * @author xbguo
 * @date 2024/9/27 16:10
 */
public class Solution19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if(len==1){
            return null;
        }
        if(len==n){
            return head.next;
        }
        int t = len - n;
        temp = head;
        while (t > 1) {
            temp = temp.next;
            t--;
        }
        temp.next=temp.next.next;

        return head;
    }
}
