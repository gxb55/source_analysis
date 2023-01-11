package com.trip.algorithm.codethink.treecode;


import com.trip.algorithm.base.TreeNode;


/**
 * @author xbguo
 * @date 2022/12/8 18:58
 * @description Solution108
 */
public class Solution108 {
    public static void main(String[] args) {
        //int[] arr = {-10, -3, 0, 5, 9};
        int[] arr = {1, 3};

        Solution108 solution108 = new Solution108();
        TreeNode res = solution108.sortedArrayToBST(arr);
        System.out.println("===============");
        TreeNode.show(res);
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = getIndex(begin, end);
        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = process(nums, begin, index - 1);
        treeNode.right = process(nums, index + 1, end);
        return treeNode;
    }

    private int getIndex(int begin, int end) {
        int i = end - begin;
        return (i / 2) + begin;
    }
}
