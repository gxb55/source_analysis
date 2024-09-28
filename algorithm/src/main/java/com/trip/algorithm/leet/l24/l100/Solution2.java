package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

public class Solution2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        while (l1 != null) {
            stringBuilder1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stringBuilder2.append(l2.val);
            l2 = l2.next;
        }
        String string1 = stringBuilder1.reverse().toString();
        String string2 = stringBuilder2.reverse().toString();
        int i = Integer.valueOf(string1) + Integer.valueOf(string2);

        String string = new StringBuilder(String.valueOf(i)).reverse().toString();
        char[] charArray = string.toCharArray();
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        int index=0;
        while (index<charArray.length){
            temp.next=new ListNode(charArray[index]-'0');
            temp=temp.next;
        }
        return listNode.next;
    }
}
