package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/9/13 15:25
 */
public class Solution1448 {
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        process(root, root.val);
        return count;
    }

    private void process(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val >= val) {
            count++;
        }
        if (root.left != null) {
            process(root.left, Math.max(val, root.left.val));
        }
        if (root.right != null) {
            process(root.right, Math.max(val, root.right.val));
        }
    }

    int count = 0;
}
