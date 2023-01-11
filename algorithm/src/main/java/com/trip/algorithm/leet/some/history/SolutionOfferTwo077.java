package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/17  15:22
 * @description 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *  
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 *  
 * <p>
 * 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/7WHec2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionOfferTwo077 {
    public static void main(String[] args) {
        SolutionOfferTwo077 solutionOfferTwo077 = new SolutionOfferTwo077();
        //-1,5,3,4,0
        ListNode listNode1 = getListNode();

        ListNode listNode = solutionOfferTwo077.sortList(listNode1);
        print(listNode);
    }



    private static void print(ListNode listNode) {
        System.out.println("----------------------------");
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode getListNode() {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        return listNode1;
    }

    /**
     * 将给定的链表 升序排列
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rightNode = getRightNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (left != null && right != null) {
            if (left.val >= right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        if (left != null && right == null) {
            cur.next = left;
        }
        if (left == null && right != null) {
            cur.next = right;
        }
        return result.next;
    }

    private ListNode getRightNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
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

