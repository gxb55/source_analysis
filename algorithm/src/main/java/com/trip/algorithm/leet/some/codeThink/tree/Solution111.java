package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月20日 16:40:00
 */
public class Solution111 {
    public static void main(String[] args) {
       // Integer[] arr = {2, null, 3, null, 4, null, 5, null, 6};
        Integer[] arr = {3,9,20,null,null,15,7};
        Solution111 solution111 = new Solution111();
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        int i = solution111.minDepth(node);
        System.out.println(i);
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode root, int curLen) {
        if(root==null){
            return;
        }
        if (root.left == null && root.right == null) {
            max = Math.min(curLen, max);
            return;
        }
        dfs(root.left, curLen + 1);
        dfs(root.right, curLen + 1);
    }

    int max = Integer.MAX_VALUE;
}
