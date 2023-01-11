package com.trip.algorithm.leet.some.leet2209;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年09月25日 10:51:00
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 * 通过次数194,740提交次数365,167
 */
public class Solution437 {
    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
       /* Integer[] root = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int targetSum = 8; */

      /*  Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;*/


        Integer[] root = {1, null, 2, null, 3, null, 4, null, 5};
        int targetSum = 3;

        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.print(treeNode);
        int process = solution437.pathSum(treeNode, targetSum);
        System.out.println();
        System.out.println(process);
    }


    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        process1(root, targetSum);
        return sum;
    }

    private void process1(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        process1(root.left, targetSum);
        process1(root.right, targetSum);
        process(root, 0, targetSum);
    }

    int sum = 0;

    private int process(TreeNode root, int cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        if ((cur + root.val) == targetSum) {
            sum++;
        }
        process(root.left, cur + root.val, targetSum);
        process(root.right, cur + root.val, targetSum);
        return 0;
    }
}
