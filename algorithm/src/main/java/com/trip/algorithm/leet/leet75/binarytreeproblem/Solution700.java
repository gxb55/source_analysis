package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/9/4 16:36
 */
public class Solution700 {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
