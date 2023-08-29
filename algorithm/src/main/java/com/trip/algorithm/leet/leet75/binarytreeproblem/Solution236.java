package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年08月27日 17:54:00
 */
public class Solution236 {
    public static void main(String[] args) {
        Integer[] root = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        // int p = 5, q = 1;
        int p = 6, q = 4;
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode treeNode1 = new TreeNode(p);
        TreeNode treeNode2 = new TreeNode(q);
        Solution236 solution236 = new Solution236();
        TreeNode treeNode3 = solution236.lowestCommonAncestor(treeNode, treeNode1, treeNode2);
        System.out.println(treeNode3.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        process(root, p, q);
        return res;
    }

    TreeNode res = null;

    private boolean process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            boolean b = get(root, q);
            if (b) {
                res = root;
            }
            return true;
        }
        if (root.val == q.val) {
            boolean b = get(root, p);
            if (b) {
                res = root;
            }
            return true;
        }
        boolean process = process(root.left, p, q);
        boolean process1 = process(root.right, p, q);
        if (process1 && process) {
            res = root;
        }
        return process || process1;
    }

    private boolean get(TreeNode root, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (q.val == root.val) {
            return true;
        }
        return get(root.right, q) || get(root.left, q);
    }
}
