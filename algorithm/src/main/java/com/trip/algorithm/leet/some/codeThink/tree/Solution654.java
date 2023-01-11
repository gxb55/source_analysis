package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月20日 19:38:00
 */
public class Solution654 {
    public static void main(String[] args) {
        Solution654 solution654 = new Solution654();
       // int[] arr = {3, 2, 1, 6, 0, 5};
        int[] arr = {3,2,1};
        TreeNode node = solution654.constructMaximumBinaryTree(arr);
        TreeNode.print(node);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int index = getMaxIndex(nums, 0, nums.length);
        TreeNode treeNode = new TreeNode(nums[index]);
        buildTree(treeNode, 0, index , nums, "L");
        buildTree(treeNode, index + 1, nums.length, nums, "R");
        return treeNode;
    }

    private void buildTree(TreeNode treeNode, int left, int right, int[] nums, String l) {
        if (left >= right) {
            return;
        }
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode treeNode1 = null;
        if (maxIndex != -1) {
            treeNode1 = new TreeNode(nums[maxIndex]);
        }
        if (l.equals("L")) {
            treeNode.setLeft(treeNode1);
        } else {
            treeNode.setRight(treeNode1);
        }
        if (maxIndex != -1) {
            buildTree(treeNode1, left, maxIndex , nums, "L");
            buildTree(treeNode1, maxIndex + 1, right, nums, "R");
        }
    }


    private int getMaxIndex(int[] nums, int i, int length) {
        int max = -1;
        int index = -1;
        for (int j = i; j < length; j++) {
            int num = nums[j];
            if (num > max) {
                max = num;
                index = j;
            }
        }
        return index;
    }
}
