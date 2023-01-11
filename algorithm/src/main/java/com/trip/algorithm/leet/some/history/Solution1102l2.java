package com.trip.algorithm.leet.some.history;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-02 19:50
 * 中等
 */
public class Solution1102l2 {
    public static void main(String[] args) {
        Solution1102l2 solution1102l2 = new Solution1102l2();
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(9);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(9);
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode re = solution1102l2.addTwoNumbers(listNode, listNode3);
        //链表补全，然后再加，如果
        ListNode listNode7 = solution1102l2.addTwoNumbersCode(listNode, listNode3);


        ListNode temp = re;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("链表补全，然后再加");
        temp = listNode7;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = handleNode(l1);
        BigInteger num2 = handleNode(l2);
        return handleResult(String.valueOf(num1.add(num2).toString()));
    }

    private ListNode handleResult(String result) {
        StringBuilder stringBuilder = new StringBuilder(result);
        StringBuilder reverse = stringBuilder.reverse();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < reverse.length(); i++) {
            list.add(Integer.parseInt(reverse.substring(i, i + 1)));
        }
        ListNode listNode = new ListNode();
        // builderNode(list, listNode, 0);
        list.stream().forEach(x -> {
            addNode(listNode, x);
        });
        return listNode.next;
    }

    private void builderNode(List<Integer> list, ListNode listNode, int i) {
        if (i == list.size()) {
            return;
        }
        listNode.val = list.get(i);
        i++;
        if (i < list.size()) {
            ListNode temp = new ListNode();
            listNode.next = temp;
            builderNode(list, temp, i);
        }
    }

    private void addNode(ListNode node, Integer val) {
        ListNode listNode = new ListNode(val);
        if (node.next == null) {
            node.next = listNode;
        } else {
            addNode(node.next, val);
        }

    }

    private BigInteger handleNode(ListNode l1) {
        if (l1 == null) {
            return new BigInteger("0");
        }
        ListNode temp = l1;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.val);
            temp = temp.next;
        }
        BigInteger integer = new BigInteger(stringBuilder.reverse().toString());
        return integer;
    }

    public ListNode addTwoNumbersCode(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        int create = 0;
        int val = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode();
            }
            if (l2.next == null && l1.next != null) {
                l2.next = new ListNode();
            }
            sum = l1.val + l2.val + create;
            val = sum % 10;
            create = sum / 10;
            System.out.println(val + "--");
            //  listNode.next=new ListNode(val);
            // listNode = listNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        System.out.println(create + "--");
        return listNode;
    }
}

