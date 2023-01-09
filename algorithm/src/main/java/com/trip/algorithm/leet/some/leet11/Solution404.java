package com.trip.algorithm.leet.some.leet11;


import com.trip.study.leetcode.TreeNode;

/**
 * @author xbguo
 * @date 2022/11/23 10:13
 * @description 404
 */
public class Solution404 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        Solution404 solution404 = new Solution404();
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.show(treeNode);
        int i = solution404.sumOfLeftLeaves(treeNode);
        System.out.println(i);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return process(root);
    }

    private Integer process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            x = root.left.val;
        }
        return process(root.left) + process(root.right) + x;

    }
}
