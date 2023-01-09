package com.trip.algorithm.leet.some.leet09;


import com.trip.study.leetcode.TreeNode;

/**
 * @author xbguo
 * @date 2022/9/2  9:48
 * @description Solution687
 */
public class Solution687 {
    public static void main(String[] args) {
        Solution687 solution687 = new Solution687();
        // Integer[] arr = {5, 4, 5, 1, 1, 5};
        Integer[] arr = {1, null, 1, 1, 1, 1, 1, 1};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.show(treeNode);
        int i = solution687.longestUnivaluePath(treeNode);
        System.out.println(i);
    }

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left1 = 0;
        int right1 = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        //两边的经过自己的
        res = Math.max(res, right1 + left1);
        // 一个树两个边，返回长的哪个
        return Math.max(right1, left1);
    }


}
