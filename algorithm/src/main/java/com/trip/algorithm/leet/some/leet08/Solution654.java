package com.trip.algorithm.leet.some.leet08;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2022/8/30  11:15
 * @description Solution654
 * 654. 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * 通过次数148,078提交次数178,500
 */
public class Solution654 {
    public static void main(String[] args) {
        Solution654 solution654 = new Solution654();
       // int[] nums = {3, 2, 1, 6, 0, 5};
        int[] nums = {3,2,1};
        TreeNode treeNode = solution654.constructMaximumBinaryTree(nums);
        TreeNode.show(treeNode);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = begin;
        int max = nums[begin];
        for (int i = begin; i <=end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = buildTree(nums, begin, index - 1);
        node.right = buildTree(nums, index + 1, end);
        return node;
    }
}
