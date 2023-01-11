package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/1/13  18:47
 * @description 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution116 {
    public static void main(String[] args) {
        /*Node root = getRoot();
        Solution116 solution116 = new Solution116();
        Node connect = solution116.connect(root);
        printNode(connect);*/

       /* Node root = getRoot();
        Solution116 solution116 = new Solution116();
        Node connect = solution116.connect1(root);*/

        Node root = getRoot();
        Solution116 solution116 = new Solution116();
        Node connect = solution116.connect2(root);
        printNode(connect);
    }

    private static void printNode(Node connect) {
        if (connect == null) {
            return;
        }
        System.out.println(connect.val + "-" + (connect.next != null ? connect.next.val : null));
        if (connect.left != null) {
            printNode(connect.left);
        }
        if (connect.right != null) {
            printNode(connect.right);
        }
    }

    private static Node getRoot() {
        Node root = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);
        root3.left = root6;
        root3.right = root7;

        root2.left = root4;
        root2.right = root5;

        root.left = root2;
        root.right = root3;
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        return getResult(root);
    }

    /**
     * 树按层级遍历放入list中，list按照1 2 4 8 的顺序设置next
     *
     * @param root
     * @return
     */
    private Node getResult(Node root) {
        List<Node> list = new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        list.add(root);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll != null) {
                if (poll.left != null) {
                    queue.add(poll.left);
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    list.add(poll.right);
                }
            }
        }
        int index = 1;
        int cur = 1;
        for (int i = 0; i < list.size(); i++) {
            index--;
            if (index == 0) {
                index = cur * 2;
                cur = index;
                list.get(i).next = null;
            } else {
                if (i + 1 < list.size()) {
                    list.get(i).next = list.get(i + 1);
                } else {
                    list.get(i).next = null;
                }
            }
        }

        return root;
    }
    //-----------------------------------------------------------------------------------------------------------------

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        getResult1(queue);
        return null;
    }

    private void getResult1(Queue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Node poll = queue.poll();
        System.out.println("------" + poll.val);
        if (poll.left != null) {
            queue.add(poll.left);
        }
        if (poll.right != null) {
            queue.add(poll.right);
        }
        getResult1(queue);
    }
    //-----------------------------------------------------------------------------------------------------------------

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        getResult2(root);
        return root;

    }

    private void getResult2(Node root) {
        if(root==null){
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if(root.next!=null){
                root.right.next = root.next.left;
            }else{
                root.right.next =null;
            }
        }
        getResult2(root.left);
        getResult2(root.right);
    }

}
