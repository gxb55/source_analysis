package com.trip.algorithm.leet.some.history;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2022/5/16  11:47
 * @description 04.06. 后继者
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 * 通过次数38,741提交次数63,076
 */
public class Solution_0406 {
    public static void main(String[] args) {
        //root = [2,1,3], p = 1
       /* TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode2.setLeft(treeNode);
        treeNode2.setRight(treeNode3);
        Solution_0406 solution_0406 = new Solution_0406();
        TreeNode treeNode1 = solution_0406.inorderSuccessor(treeNode2, treeNode);
        System.out.println(treeNode1);
        TreeNode treeNode4 = solution_0406.inorderSuccessor2(treeNode2, null);*/

        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        TreeNode p = new TreeNode(1);
        Solution_0406 solution_0406 = new Solution_0406();
        TreeNode treeNode1 = solution_0406.inorderSuccessor(treeNode, p);
        System.out.println(treeNode1.val);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.p = p;
        process(root);
        return pre;
    }

    private TreeNode p;
    private TreeNode pre = null;
    private boolean flag = false;

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (flag) {
            if(pre==null){
                pre = root;
            }
            return;
        }
        if (root.val == p.val) {
            flag = true;
        }
        process(root.right);

    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr == p) {
                return prev;
            }
            prev = curr;
            System.out.println(curr.val);
            curr = curr.right;
        }
        return null;
    }

}
