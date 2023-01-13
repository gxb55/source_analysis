package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月19日 18:50:00
 */
public class Solution226 {
    public static void main(String[] args) {
        Solution226 solution226 = new Solution226();
        Integer[] arr={4,2,7,1,3,6,9};
        TreeNode node1 = TreeNode.buildTree(arr);
        TreeNode node = solution226.invertTree(node1);
        TreeNode.print(node);
    }

    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        process(root.left);
        process(root.right);
    }
}
