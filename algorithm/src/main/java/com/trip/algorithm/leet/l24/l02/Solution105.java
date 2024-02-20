package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2024/2/20 19:11
 */
public class Solution105 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = solution105.buildTree(preorder, inorder);
        TreeNode.print(treeNode);
    }

    /**
     * 根左右
     * 左根右
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode process = process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return process;
    }

    private TreeNode process(int[] preorder, int left, int right, int[] inorder, int left1, int right1) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(preorder[left]);
        }
        // 根左右；左根右
        int cur = preorder[left];
        int index = -1;
        for (int i = left1; i <= right1; i++) {
            if (cur == inorder[i]) {
                index = i;
                break;
            }
        }
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int len = index - left1;
        TreeNode treeNode = new TreeNode(cur);
        treeNode.left = process(preorder, left + 1, left + 1 + len - 1, inorder, left1, left1 + len - 1);
        treeNode.right = process(preorder, left + 1 + len, right, inorder, left1 + len + 1, right1);
        return treeNode;
    }
}
