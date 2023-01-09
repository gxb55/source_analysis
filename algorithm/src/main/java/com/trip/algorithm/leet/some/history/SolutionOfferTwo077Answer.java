package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/17  17:19
 * @description 答案
 */
public class SolutionOfferTwo077Answer {

    public static void main(String[] args) {
        SolutionOfferTwo077Answer answer = new SolutionOfferTwo077Answer();
        //-1,5,3,4,0
        int[] arr = {-1, 5, 3, 4, 0};
        ListNode listNode1 = getListNode(arr);
        print(listNode1);
        System.out.println("---------------------");
        ListNode listNode = answer.sortList(listNode1);
        print(listNode);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);        //一条链表分成两段分别递归排序
        head2 = sortList(head2);

        return merge(head1, head2);     //返回合并后结果
    }

    private static ListNode getListNode(int[] arr) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return node.next;
    }

    //双指针找单链表中点模板
    public ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;           //断尾

        return mid;
    }

    //合并两个排序链表模板
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p = p.next = head1;
                head1 = head1.next;
            } else {
                p = p.next = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null) p.next = head1;
        if (head2 != null) p.next = head2;

        return dummy.next;
    }

    private static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
