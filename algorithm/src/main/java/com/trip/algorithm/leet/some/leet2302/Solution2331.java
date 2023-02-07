package com.trip.algorithm.leet.some.leet2302;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/2/6 09:30
 * @description 2331
 */
public class Solution2331 {
    public static void main(String[] args) {
        Solution2331 solution2331 = new Solution2331();

    }

    public boolean evaluateTree(TreeNode root) {
        return process(root);
    }

    /**
     * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
     * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
     */
    private boolean process(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 0 ? false : true;
        }
        boolean process1 = process(root.left);
        boolean process = process(root.right);

        return root.val == 2 ? process || process1 : process && process1;
    }
}
