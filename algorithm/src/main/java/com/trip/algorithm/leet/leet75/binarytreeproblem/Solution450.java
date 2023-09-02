package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年08月30日 21:36:00
 */
public class Solution450 {
    public static void main(String[] args) {
        Solution450 solution450 = new Solution450();
        Integer[] root = {5, 3, 6, 2, 4, null, 7};
        int key = 3;
        TreeNode tree = TreeNode.buildTree(root);
        TreeNode treeNode = solution450.deleteNode(tree, key);
        TreeNode.print(treeNode);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                return null;
            } else if (left == null && right != null) {
                return right;
            } else if (left != null && right == null) {
                return left;
            } else {
                TreeNode cur = right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = left;
                return right;
            }
        }
        process(root, key, null, "");
        return root;
    }

    private void process(TreeNode root, int key, TreeNode parent, String t) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) {
                if (t.equals("L")) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (left == null && right != null) {
                if (t.equals("L")) {
                    parent.left = right;
                } else {
                    parent.right = right;
                }
            } else if (left != null && right == null) {
                if (t.equals("L")) {
                    parent.left = left;
                } else {
                    parent.right = left;
                }
            } else {
                if (t.equals("L")) {
                    parent.left = right;
                } else {
                    parent.right = right;
                }
                TreeNode cur = right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = left;

            }
        }
        if (key < val) {
            process(root.left, key, root, "L");
        } else {
            process(root.right, key, root, "R");
        }
    }
}
