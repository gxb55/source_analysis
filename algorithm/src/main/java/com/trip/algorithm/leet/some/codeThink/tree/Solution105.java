package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年12月03日 10:24:00
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * 通过次数442,731提交次数620,421
 */
public class Solution105 {
    public static void main(String[] args) {
        Solution105 solution105 = new Solution105();
        //为二叉树的前序遍历序列 根 左 右
        int[] preorder = {3, 9, 20, 15, 7};
        //为二叉树的中序遍历序列 左 根 右
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = solution105.buildTree(preorder, inorder);
        TreeNode.print(node);
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return process(0, preorder.length - 1, 0, inorder.length - 1);
    }
    int[] preorder;
    int[] inorder;
    private TreeNode process(int left, int right, int inLeft, int inRight) {
        if (left > right) {
            return null;
        }
        int i = preorder[left];
        TreeNode treeNode = new TreeNode(i);
        int j = inLeft;
        for (; j < inRight; j++) {
            if (i == inorder[j]) {
                break;
            }
        }
        int leftLen = j - inLeft - 1;
        treeNode.left = process(left + 1, left + 1 + leftLen, inLeft, j - 1);
        treeNode.right = process(left + 1 + leftLen + 1, right, j + 1, inRight);
        return treeNode;
    }
}
