package com.trip.algorithm.leet.some.leet2305;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/5/22 13:55
 * @description TODO
 */
public class Solution1080 {
    public static void main(String[] args) {
        Solution1080 solution1080 = new Solution1080();
        Integer[] root = {5, 4, 8, 11, null, 17, 4, 7, 1, null, null, 5, 3};
        int limit = 22;
        TreeNode treeNode1 = TreeNode.buildTree(root);
        TreeNode.print(treeNode1);
        TreeNode treeNode = solution1080.sufficientSubset(treeNode1, limit);
        TreeNode.print(treeNode);

    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val < limit ? null : root;// 叶子节点直接返回
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return root.left == null && root.right == null ? null : root;
    }





}
