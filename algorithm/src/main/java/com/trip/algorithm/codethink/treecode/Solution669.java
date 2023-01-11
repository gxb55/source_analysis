package com.trip.algorithm.codethink.treecode;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2022/12/8 17:15
 * @description Solution669
 */
public class Solution669 {
    public static void main(String[] args) {
        Solution669 solution669 = new Solution669();
      /*  Integer[] arr = {1,0,2};
        int low = 1;
        int high = 2; */

        Integer[] arr = {3,0,4,null,2,null,null,1};
        int low = 1;
        int high = 2;

        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.show(treeNode);

        TreeNode res = solution669.trimBST(treeNode, low, high);
        System.out.println("===============");
        TreeNode.show(res);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode res = new TreeNode(-1);
        res.left = root;
        process(root, low, high, res, "L");
        return res.left;
    }

    private void process(TreeNode root, int low, int high, TreeNode res, String l) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (val < low) {
            if (l.equals("L")) {
                res.left = root.right;
                process(res.left, low, high, res, "L");
            } else {
                res.right = root.right;
                process(res.right, low, high, res, "R");
            }

        } else if (val > high) {
            if (l.equals("L")) {
                res.left = root.left;
                process(res.left, low, high, res, "L");
            } else {
                res.right = root.left;
                process(res.right, low, high, res, "R");
            }
        } else {
            process(root.left, low, high, root, "L");
            process(root.right, low, high, root, "R");
        }
    }
}
