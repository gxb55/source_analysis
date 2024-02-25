package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

public class Solution235 {
    public static void main(String[] args) {
        Integer[] root = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        int p = 9, q = 7;
        Solution235 solution235 =new Solution235();
        TreeNode treeNode = solution235.lowestCommonAncestor(TreeNode.buildTree(root), new TreeNode(p), new TreeNode(q));
        System.out.println(treeNode.val);
        TreeNode.print(treeNode);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val) {
            return process(root, q, p);
        } else {
            return process(root, p, q);
        }

    }

    private TreeNode process(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val >= q.val && val <= p.val) {
            return root;
        }
        if (val > p.val) {
            return process(root.left, q, p);
        } else
            return process(root.right, q, p);
    }
}
