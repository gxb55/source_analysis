package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

public class Solution938 {
    public static void main(String[] args) {
        Integer[] root = {10, 5, 15, 3, 7, null, 18};
        int low = 7, high = 15;
        Solution938 solution938 = new Solution938();
        int i = solution938.rangeSumBST(TreeNode.buildTree(root), low, high);
        System.out.println(i);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return process(root, low, high);
    }

    private Integer process(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val > high) {
            return process(root.left, low, high);
        } else if (val < low) {
            return process(root.right, low, high);
        } else {
            return process(root.left, low, high) + val +
                    process(root.right, low, high);
        }

    }
}
