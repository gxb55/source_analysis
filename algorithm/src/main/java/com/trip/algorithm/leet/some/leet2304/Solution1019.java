package com.trip.algorithm.leet.some.leet2304;

import com.trip.algorithm.leet.some.history.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/4/10 16:21
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * [1,7,5,1,9,2,5,1]
 * 输出：
 * [9,9,9,9,0,5,0,0]
 * 预期结果：
 * [7,9,9,9,0,5,0,0]
 */
public class Solution1019 {
    public static void main(String[] args) {
          // int[] head = {2, 1, 5};
           int[] head = {1,7,5,1,9,2,5,1};
      //  int[] head = {2, 7, 4, 3, 5};
        ListNode listNode = ListNode.buildListNode(head);
        int[] ints = nextLargerNodes1(listNode);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            ListNode temp = cur.next;
            while (temp != null && val >= temp.val) {
                temp = temp.next;
            }
            list.add(temp == null ? 0 : temp.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] nextLargerNodes1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            int val = cur.val;
            list.add(val);
            cur = cur.next;
        }
        int[] arr = new int[list.size()];
        Deque<Integer> deque = new ArrayDeque<>();
        // 从后到前遍历
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer integer = list.get(i);
            while (!deque.isEmpty() && integer >= deque.peek()) {
                deque.poll();
            }
            if (!deque.isEmpty()) {
                arr[i] = deque.peek();
            }
            deque.push(integer);
        }
        return arr;
    }


}
