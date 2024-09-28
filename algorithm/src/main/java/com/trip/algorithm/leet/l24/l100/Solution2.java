package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.leet.some.history.ListNode;

public class Solution2 {
    public static void main(String[] args) {

        ListNode listNode = addTwoNumbers(
                ListNode.buildListNode(new int[]{9,9,9,9,9,9,9}),
                ListNode.buildListNode(new int[]{9, 9, 9, 9}));
        listNode.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        int last1 = string1.length() - 1;
        int last2 = string2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int v = 0;
        while (last2 >= 0 || last1 >= 0) {
            if (last2 >= 0 && last1 >= 0) {
                int i1 = string1.charAt(last1) - '0';
                int i2 = string2.charAt(last2) - '0';
                int val = i2 + i1 + v;
                int lastV = val / 10;
                int t = val % 10;
                stringBuilder.append(t);
                v = lastV;
                last2--;
                last1--;
            } else if (last2 < 0 && last1 >= 0) {
                int i1 = string1.charAt(last1) - '0';
                int val =  i1 + v;
                int lastV = val / 10;
                int t = val % 10;
                stringBuilder.append(t);
                v = lastV;
                last1--;
            } else {
                int i2 = string2.charAt(last2) - '0';
                int val = i2  + v;
                int lastV = val / 10;
                int t = val % 10;
                stringBuilder.append(t);
                v = lastV;
                last2--;
            }
        }
        if(v!=0){
            stringBuilder.append(v);
        }

        String string = stringBuilder.toString();
        char[] charArray = string.toCharArray();
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        int index = 0;
        while (index < charArray.length) {
            temp.next = new ListNode(charArray[index] - '0');
            temp = temp.next;
            index++;
        }
        return listNode.next;
    }

    private static ListNode resert(ListNode l1) {
        ListNode pre = new ListNode();

        while (l1 != null) {
            ListNode next = l1.next;
            ListNode next1 = pre.next;
            pre.next = l1;
            l1.next = next1;

            l1 = next;
        }
        return pre.next;
    }
}
