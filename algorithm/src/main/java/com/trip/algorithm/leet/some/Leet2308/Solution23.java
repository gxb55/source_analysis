package com.trip.algorithm.leet.some.Leet2308;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年08月12日 12:15:00
 */
public class Solution23 {
    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        int[][] lists = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] res = new ListNode[3];
        for (int i = 0; i < lists.length; i++) {
            res[i]=ListNode.buildListNode(lists[i]);
        }
        ListNode listNode = solution23.mergeKLists(res);
        ListNode.printNode(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode parent = new ListNode();
        ListNode temp = parent;
        List<ListNode> nodeList = Arrays.stream(lists).collect(Collectors.toList());
        while (true) {
            ListNode listNode = null;
            int index=-1;
            for (int i = 0; i < nodeList.size(); i++) {
                ListNode node = nodeList.get(i);
                if (listNode == null && node != null) {
                    listNode = node;
                    index=i;
                }
                if (node != null && node.val < listNode.val) {
                    listNode = node;
                    index=i;
                }
            }
            if (listNode == null) {
                break;
            }
            temp.next = listNode;
            temp = temp.next;
            listNode = listNode.next;
            nodeList.set(index,listNode);
            nodeList=nodeList.stream().filter(x->x!=null).collect(Collectors.toList());
        }
        return parent.next;
    }
}
