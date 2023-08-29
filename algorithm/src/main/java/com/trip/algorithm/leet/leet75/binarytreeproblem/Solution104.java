package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年08月27日 16:48:00
 */
public class Solution104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        return process(root);
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(process(root.left) + 1, process(root.right) + 1);
    }
}
