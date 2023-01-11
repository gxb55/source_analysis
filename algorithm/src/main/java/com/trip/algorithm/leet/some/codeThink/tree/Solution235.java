package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年12月06日 16:24:00
 */
public class Solution235 {
    public static void main(String[] args) {

        Solution235 solution236 = new Solution235();
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode node1 = TreeNode.buildTree(arr);
        TreeNode.print(node1);
        int v = 2;
        int u = 9;
        TreeNode node = solution236.lowestCommonAncestor(node1, new TreeNode(v), new TreeNode(u));
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q);
    }

    private TreeNode process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val == p.val || val == q.val) {
            return root;
        }
        TreeNode process = null;
        TreeNode process1 = null;
        if (val > p.val && val > q.val) {
            process = process(root.left, p, q);
        } else if (val < p.val && val < q.val) {
            process1 = process(root.right, p, q);
        } else {
           return root;
        }

        if (process1 != null && process != null) {
            return root;
        } else if (process1 == null && process != null) {
            return process;
        } else if (process1 != null && process == null) {
            return process1;
        }
        return null;
    }
}
