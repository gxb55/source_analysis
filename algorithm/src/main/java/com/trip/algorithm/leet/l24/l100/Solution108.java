package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.base.TreeNode;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/10/18 14:25
 */
public class Solution108 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        TreeNode treeNode = sortedArrayToBST(arr);
        TreeNode.print(treeNode);
        TreeNode.print(sortedArrayToBST1(arr));
    }

    public static TreeNode sortedArrayToBST1(int[] nums) {
        //每次将中点作为根节点，其左边的所有元素作为左子树，右边的所有元素作为右子树
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST1(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST1(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int length = nums.length;
        int index = length / 2;

        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = process(nums, 0, index - 1);
        treeNode.right = process(nums, index + 1, length - 1);
        return treeNode;
    }

    private static TreeNode process(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = process(nums, l, mid - 1);
        treeNode.right = process(nums, mid + 1, r);
        return treeNode;
    }

}
