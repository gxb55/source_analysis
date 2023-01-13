package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年12月06日 17:39:00
 */
public class Solution450 {
    public static void main(String[] args) {
        Solution450 solution450 = new Solution450();
        //Integer[] arr= {3,9,20,null,null,15,7};
       /* Integer[] arr = {5, 3, 6, 2, 4, null, 7};
        int val = 5; */
       /* Integer[] arr = {3,2,5,null,null,4,10,null,null,8,15,7};
        int val = 5; */

     /*   Integer[] arr = {2, 1};
        int val = 1; */

        Integer[] arr = {3,2,4,1};
        int val = 2;
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        TreeNode node1 = solution450.deleteNode(node, val);
        TreeNode.print(node1);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode right1 = right;
            if (right1 != null) {
                while (right1.left != null) {
                    right1 = right1.left;
                }
                right1.left = left;
                return right;
            } else {
                return left;
            }

        }
        TreeNode parent = null;
        TreeNode temp = root;
        boolean flag = false;
        while (temp != null) {
            int val = temp.val;
            if (val > key) {
                parent = temp;
                temp = temp.left;
            } else if (val < key) {
                parent = temp;
                temp = temp.right;
            } else {
                flag = true;
                break;
            }

        }
        if (!flag) {
            return root;
        }

        if (parent.left != null && parent.left.val == key) {
            TreeNode left = parent.left.left;
            TreeNode right = parent.left.right;
            TreeNode right1 = right;
            if (right1 != null) {
                while (right1.left != null) {
                    right1 = right1.left;
                }
                right1.left = left;
                parent.left = right;
            }else{
                parent.left=left;
            }
        } else {
            TreeNode left = parent.right.left;
            TreeNode right = parent.right.right;
            TreeNode right1 = right;
            if (right1 != null) {
                while (right1.left != null) {
                    right1 = right1.left;
                }
                right1.left = left;
                parent.right = right;
            }else{
                parent.right=left;
            }

        }
        return root;
    }
}
