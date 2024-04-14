package com.trip.algorithm.leet.l24.l04;

import com.trip.algorithm.base.TreeNode;

public class Solution1026 {
    public static void main(String[] args) {
        Integer[] arr = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        Solution1026 solution1026 = new Solution1026();
        int i = solution1026.maxAncestorDiff(TreeNode.buildTree(arr));
        System.out.println(i);
    }

    public int maxAncestorDiff(TreeNode root) {
        process(root, root.val, root.val);
        return res;
    }

    int res = 0;

    private void process(TreeNode root, int max, int min) {
        if (root == null) {
            res = Math.max(res, Math.abs(max - min));
            return;
        }
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        process(root.left, max, min);
        process(root.right, max, min);
    }
}
