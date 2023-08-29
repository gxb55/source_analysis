package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年08月27日 17:28:00
 * root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：0
 */
public class Solution1372 {
    public static void main(String[] args) {
        Solution1372 solution1372 = new Solution1372();
       // Integer[] root = {1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1};
      //  Integer[] root = {1,1,1,null,1,null,null,1,1,null,1};
        Integer[] root = {1};
        TreeNode treeNode = TreeNode.buildTree(root);
        int i = solution1372.longestZigZag(treeNode);
        System.out.println(i);
    }

    public int longestZigZag(TreeNode root) {
        int cur = 0;
        process(root.left, cur, "L");
        process(root.right, cur, "R");
        return max;
    }
    int max = 0;
    private void process(TreeNode root, int cur, String l) {
        if (root == null) {
            max = Math.max(max, cur);
            return;
        }
        if (l.equals("L")) {
            process(root.right, cur + 1, "R");
            process(root.left, 0, "L");
        } else if (l.equals("R")) {
            process(root.right, 0, "R");
            process(root.left, cur + 1, "L");
        }
    }
}
