package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月20日 17:59:00
 */
public class Solution110 {
    public static void main(String[] args) {
        Solution110 solution110 = new Solution110();
        //Integer[] arr= {3,9,20,null,null,15,7};
        Integer[] arr= {1,2,2,3,3,null,null,4,4};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        boolean balanced = solution110.isBalanced(node);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    boolean flag = true;

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLen = dfs(root.left) + 1;
        int rightLen = dfs(root.right) + 1;
        if (Math.abs(leftLen - rightLen) > 1) {
            flag = false;
        }
        return Math.max(leftLen, rightLen);
    }
}
