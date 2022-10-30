package com.trip.algorithm.leet.some.leet2209;

/**
 * @author xbguo
 * @createTime 2022年09月24日 10:31:00
 */
public class Solution707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3

                    //返回2
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        //返回3
        System.out.println(linkedList.get(1));

       /* MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        System.out.println(linkedList.get(1));*/

    }

}

class LinkedNode {
    public int val;
    public LinkedNode next;
    public LinkedNode prev;

    public LinkedNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    LinkedNode head;
    int len = 0;

    public MyLinkedList() {
        head = new LinkedNode(-1);

    }

    public int get(int index) {
        if (index+1 > len) {
            return -1;
        }
        LinkedNode temp = head;
        while (temp.next != null && index >= 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        LinkedNode node = new LinkedNode(val);
        LinkedNode next = head.next;

        head.next = node;
        node.prev = head;
        if (next != null) {
            node.next = next;
            next.prev = node;
        }
        len++;
    }

    public void addAtTail(int val) {
        LinkedNode last = getLast();
        LinkedNode node = new LinkedNode(val);
        last.next = node;
        node.prev = last;
        len++;
    }

    /**
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/design-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        } else if (index > len) {

        } else {
            LinkedNode temp = head;
            while (temp.next != null && index >= 1) {
                temp = temp.next;
                index--;
            }
            LinkedNode next = temp.next;
            LinkedNode node = new LinkedNode(val);
            temp.next = node;
            node.prev = temp;
            if (next != null) {
                node.next = next;
                next.prev = node;
            }
            len++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index > len) {
            return;
        }
        LinkedNode temp = head;
        while (temp.next != null && index >= 1) {
            temp = temp.next;
            index--;
        }
        LinkedNode next = temp.next;
        LinkedNode next1 = next.next;
        if (next1 != null) {
            temp.next = next1;
            next1.prev = temp;
        } else {
            temp.next = null;
        }
        len--;
    }

    public LinkedNode getLast() {
        LinkedNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        LinkedNode temp = head;
        while (temp.next != null) {
            stringBuffer.append(temp.next.val).append("->");
            temp = temp.next;
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }
}