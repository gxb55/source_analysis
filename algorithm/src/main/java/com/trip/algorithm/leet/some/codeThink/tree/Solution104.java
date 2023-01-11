package com.trip.algorithm.leet.some.codeThink.tree;


import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月20日 11:16:00
 */
public class Solution104 {
    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        int i = solution104.maxDepth(node);
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int curLen) {
        if (root == null) {
            max = Math.max(curLen, max);
            return;
        }
        dfs(root.left, curLen + 1);
        dfs(root.right, curLen + 1);
    }

    int max = 0;
}
