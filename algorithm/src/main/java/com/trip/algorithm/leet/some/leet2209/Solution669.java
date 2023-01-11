package com.trip.algorithm.leet.some.leet2209;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年09月12日 21:32:00
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是 唯一 的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 * 通过次数95,689提交次数140,460
 */
public class Solution669 {
    public static void main(String[] args) {
        Solution669 solution669 = new Solution669();
     /*   Integer[] root = {1, 0, 2};
        int low = 1, high = 2;*/

        Integer[] root = {3, 0, 4, null, 2, null, null, 1};
        int low = 1, high = 3;
        TreeNode node1 = TreeNode.buildTree(root);
        TreeNode.print(node1);
        TreeNode node = solution669.trimBST(node1, low, high);
        TreeNode.print(node);
    }


    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode node = new TreeNode(-1);
        node.left = root;
        process(node, low, high);
        return node.left;
    }

    private void process(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.val < low) {
                left.left = null;
                root.left = left.right;
                process(root, low, high);
            } else if (left.val > high) {
                left.right = null;
                root.left = left.left;
                process(root, low, high);
            } else {
                process(root.left, low, high);
            }
        }
        if (root.right != null) {
            TreeNode right = root.right;
            if (right.val < low) {
                right.left = null;
                root.right = right.right;
                process(root, low, high);
            } else if (right.val > high) {
                right.right = null;
                root.right = right.left;
                process(root, low, high);
            } else {
                process(root.right, low, high);
            }
        }
    }
}
