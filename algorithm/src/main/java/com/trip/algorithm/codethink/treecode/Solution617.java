package com.trip.algorithm.codethink.treecode;


import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/12/1 15:33
 * @description Solution617
 */
public class Solution617 {
    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1, 3, 2, 5});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode.show(treeNode1);
        TreeNode.show(treeNode2);
        TreeNode treeNode = solution617.mergeTrees(treeNode1, treeNode2);
        TreeNode.show(treeNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return process(root1, root2);
    }

    private TreeNode process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val1 = root1 == null ? 0 : root1.val;
        int val2 = root2 == null ? 0 : root2.val;
        TreeNode treeNode = new TreeNode(val1 + val2);
        treeNode.left = process(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        treeNode.right = process(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return treeNode;

    }

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }

}
