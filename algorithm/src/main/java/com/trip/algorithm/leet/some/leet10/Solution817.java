package com.trip.algorithm.leet.some.leet10;

import com.trip.study.leetcode.history.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: xbguo
 * @date: 2022/10/12 17:15
 * @description: Solution817
 */
public class Solution817 {
    public static void main(String[] args) {
        Solution817 solution817 = new Solution817();
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode.next = listNode1;
         int[] arr={0,1,3};
       /* int[] arr = {0, 3, 1, 4};
        int[] arr = {0, 2};*/
        int i = solution817.numComponents(listNode, arr);
        System.out.println(i);
    }

    public int numComponents(ListNode head, int[] nums) {
        int max = 0;
        int cur;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        while (head != null) {
            cur = 0;
            while (head != null && list.contains(head.val)) {
                head = head.next;
                cur++;
            }
            if (cur == 0) {
                head = head.next;
            }else{
                max++;
            }
        }
        return max;
    }

}
