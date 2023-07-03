package com.trip.algorithm.leet.some.leet2307;

import com.trip.algorithm.leet.some.codeThink.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年07月02日 15:33:00
 */
public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        /*int[] l1 = {9, 9, 9, 9, 9, 9, 9};
        int[] l2 = {9, 9, 9, 9};*/
        int[] l1 = {2, 4, 9};
        int[] l2 = {5, 6, 4, 9};
        ListNode build1 = ListNode.build(l1);
        ListNode build2 = ListNode.build(l2);
        ListNode listNode = solution02.addTwoNumbers(build1, build2);
        ListNode.print(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int res = 0;
        while (index2 < list2.size() || index1 < list1.size()) {
            Integer integer = 0;
            Integer integer1 = 0;
            if (index1 < list1.size()) {
                integer = list1.get(index1);
            }
            if (index2 < list2.size()) {
                integer1 = list2.get(index2);
            }
            int k = integer + integer1 + res;
            if (k < 10) {
                res = 0;
            } else {
                res = k / 10;
            }
            k = k % 10;
            list.add(k);
            index1++;
            index2++;
        }
        if (res != 0) {
            list.add(res);
        }
        int index = 0;
        ListNode resultNode = new ListNode();
        resultNode.val = list.get(index);
        ListNode temp = resultNode;
        index++;
        while (index < list.size()) {
            temp.next = new ListNode(list.get(index));
            temp = temp.next;
            index++;
        }
        return resultNode;
    }
}
