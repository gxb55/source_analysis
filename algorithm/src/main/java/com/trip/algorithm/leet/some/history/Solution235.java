package com.trip.algorithm.leet.some.history;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2022/4/24  14:51
 * @description 235
 */
public class Solution235 {
    public static void main(String[] args) {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode treeNode = TreeNode.createTreeNode(arr);
        System.out.println(treeNode);


        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);

        root.left = root2;
        root.right = root8;
        root8.left = root7;
        root8.right = root9;
        root2.left = root0;
        root2.right = root4;

        root4.left = root3;
        root4.right = root5;

        Solution235 solution235 = new Solution235();
        solution235.lowestCommonAncestor(root, root0, root9);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        process(root, p, q);
        return cur;
    }

    TreeNode cur = null;

    private void process(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        if (p.val < val && q.val < val) {
            process(root.left, p, q);
        } else if (p.val > val && q.val > val) {
            process(root.right, p, q);
        } else {
            cur = root;
        }
    }


}

