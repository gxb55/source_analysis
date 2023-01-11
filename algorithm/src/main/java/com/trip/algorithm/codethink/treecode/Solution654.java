package com.trip.algorithm.codethink.treecode;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2022/11/30 18:55
 * @description Solution654
 */
public class Solution654 {
    public static void main(String[] args) {
        Solution654 solution654 = new Solution654();
      //  int[] arr = {3, 2, 1, 6, 0, 5};
        int[] arr = {3, 2, 1};
        TreeNode treeNode = solution654.constructMaximumBinaryTree(arr);
        TreeNode.show(treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = getMaxIndex(nums, begin, end);
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = process(nums, begin, index - 1);
        treeNode.right = process(nums, index + 1, end);
        return treeNode;
    }

    private int getMaxIndex(int[] nums, int begin, int end) {
        int max = nums[begin];
        int index = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
