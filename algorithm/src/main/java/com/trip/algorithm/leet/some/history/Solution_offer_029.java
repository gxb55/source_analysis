package com.trip.algorithm.leet.some.history;


/**
 * @author xbguo
 * @createTime 2022年06月18日 09:26:00
 * 剑指 Offer II 029. 排序的循环链表
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 * 示例 3：
 * <p>
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 * <p>
 * <p>
 * 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
 * <p>
 * 通过次数17,160提交次数54,179
 */
public class Solution_offer_029 {
    public static void main(String[] args) {

        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node1 = new Node(4);
        node1.next = node3;
        node3.next = node4;
        node4.next = node1;
        Solution_offer_029 solutionOffer029 = new Solution_offer_029();
        Node insert = solutionOffer029.insert(node3, 2);
        System.out.println(insert.val);
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node cur = head;
        Node next = head.next;
        while (cur.val != next.val) {
            // 找到了合适的位置
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            // 首位相连处，大于最大的或者小于最小的
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = node;
        node.next = next;
        return head;
    }


}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};