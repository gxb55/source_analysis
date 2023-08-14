package com.trip.algorithm.leet.some.Leet2308;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/8/14 14:43
 */
public class Solution617 {
    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();
        //Integer[] root1 = {1, 3, 2, 5}, root2 = {2, 1, 3, null, 4, null, 7};
        Integer[] root1 = {1}, root2 = {1, 7};
        TreeNode treeNode = solution617.mergeTrees(TreeNode.buildTree(root1), TreeNode.buildTree(root2));
        TreeNode.print(treeNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return  process(root1, root2);
    }

    private TreeNode process(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            root1.left = process(root1.left, root2.left);
            root1.right = process(root1.right, root2.right);
            return root1;
        } else if (root1 == null && root2 != null) {
            return root2;
        } else if (root1 != null && root2 == null) {
            return root1;
        }
        return null;
    }
}
