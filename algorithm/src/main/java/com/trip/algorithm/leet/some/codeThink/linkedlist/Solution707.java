package com.trip.algorithm.leet.some.codeThink.linkedlist;

/**
 * @author xbguo
 * @createTime 2022年11月05日 18:28:00
 */
public class Solution707 {
    public static void main(String[] args) {
       /* MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1)); //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3*/

      /*  MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(5 );*/

        /**
         * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
         * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
         */

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        System.out.println(linkedList.get(0));
/*["MyLinkedList","addAtTail","get"]
[[],[1],[0]]*/

    }
}

class MyLinkedList {
    ListNode head;
    int len;

    public MyLinkedList() {
        head = new ListNode(-1);
        len = 0;
    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * 下标从0开始计算
     * @param index
     * @return
     */
    public int get(int index) {
        if (index >= len) {
            return -1;
        }
        ListNode temp = head;
        while (index >= 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        ListNode next = head.next;
        head.next = temp;
        temp.next = next;
        len++;
    }

    public void addAtTail(int val) {
        len++;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index  > len) {
            return;
        }
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        ListNode next = temp.next;
        ListNode listNode = new ListNode(val);
        temp.next=listNode;
        listNode.next=next;
        len++;
    }

    public void deleteAtIndex(int index) {
        if (index + 1 > len) {
            return;
        }
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;
        len--;
    }


}
