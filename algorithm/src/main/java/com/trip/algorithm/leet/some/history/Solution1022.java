package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/30  8:49
 * @description 1022
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 * 通过次数26,871提交次数37,146
 */
public class Solution1022 {
    public static void main(String[] args) {
        Solution1022 solution1022 = new Solution1022();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(0);
        TreeNode root5 = new TreeNode(0);
        TreeNode root6 = new TreeNode(0);
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        root.left = root1;
        root.right = root2;

      /*  TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(1);
        root.left=root1;*/
        Integer[] arr = {0, 1, 0, 0, null, 0, 0, null, null, null, 1, null, null, null, 1};
        TreeNode treeNode = TreeNode.createTreeNode(arr);
        int i = solution1022.sumRootToLeaf(treeNode);
        System.out.println(i);
    }

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        int val = 0;
        return process(root, val);
    }

    private int process(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return process(root.left, val) + process(root.right, val);
    }
}
