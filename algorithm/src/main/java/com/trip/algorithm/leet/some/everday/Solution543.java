package com.trip.algorithm.leet.some.everday;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年08月07日 22:18:00
 * Solution543
 */
public class Solution543 {
    public static void main(String[] args) {
        Solution543 solution543 = new Solution543();
        Integer[] arr = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.print(treeNode);
        int i = solution543.diameterOfBinaryTree(treeNode);
        System.out.println(i);
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 1;
        }
        res = Math.max(res, process(root.left) + process(root.right));
        getMax(root.left);
        getMax(root.right);
        return 0;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int p1 = process(root.left) + 1;
        int p2 = process(root.right) + 1;
        return Math.max(p1, p2);
    }
}
