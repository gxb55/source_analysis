package com.trip.algorithm.leet.l24.l01;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/1/15 19:11
 */
public class Solution82 {
    public static void main(String[] args) {
        Solution82 solution82 =new Solution82();
       // int[] head = {1,2,3,3,4,4,5};
        int[] head = {1,1,1,2,3};
        ListNode listNode = solution82.deleteDuplicates(ListNode.buildListNode(head));
        listNode.print();
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            Integer orDefault = map.getOrDefault(cur.val, 0);
            map.put(cur.val, orDefault + 1);
            cur = cur.next;
        }
        List<Integer> list = map.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
        ListNode pre = new ListNode();
        pre.setVal(1000);
        pre.next = head;
        cur = pre;
        while (cur.next != null) {
            if (list.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
