package com.trip.algorithm.codethink.linkedlist;

import com.trip.study.leetcode.history.ListNode;

import java.util.Stack;

/**
 * @auther: xbguo
 * @date: 2022/11/7 16:20
 * @description: 双指针法，比较好，
 *
 * 假如 链表 A B 不相交部分为 a1 b1 相交部分为c
 *
 * p1 指针 走的距离为 a1+c+b1
 * p2 指针 走的距离为 b1+c+a1 最终相遇；
 *
 * 如果A B不相交 则
 * p1 走的距离是 a+b
 * p2 走的距离是 b+a 最终都会指向null
 *
 *
 *
 */
public class Solution160 {
    public static void main(String[] args) {

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (tempA != null) {
            stackA.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            stackB.add(tempB);
            tempB = tempB.next;
        }
        boolean flag = false;
        while (!stackB.isEmpty() && !stackA.isEmpty()) {
            if (stackB.peek() == stackA.peek()) {
                flag = true;
                stackB.pop();
                res = stackA.pop();
            } else {
                if (flag) {
                    break;
                } else {
                    return null;
                }
            }
        }
        return res;
    }


}
