package com.trip.algorithm.leet.some.everday;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年08月01日 22:41:00
 */
public class Solution236 {
    public static void main(String[] args) {
        Solution236 solution236 = new Solution236();
      /*  Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);*/

        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        TreeNode treeNode1 = solution236.lowestCommonAncestor(treeNode, p, q);
        System.out.println(treeNode1.val);

    }

    public TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        process(root, p, q);
        return res;
    }

    private boolean process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = process(root.left, p, q);
        boolean right = process(root.right, p, q);

        if ((left && right) || (left || right) && (root.val == p.val || root.val == q.val)) {
            res = root;
        }
        return left || right||root.val == p.val || root.val == q.val;

    }
}
