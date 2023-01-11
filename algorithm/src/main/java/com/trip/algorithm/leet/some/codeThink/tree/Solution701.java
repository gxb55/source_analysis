package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年12月06日 16:59:00
 */
public class Solution701 {
    public static void main(String[] args) {
        Solution701 solution701 = new Solution701();
       /* Integer[] arr = {4,2,7,1,3};
        int v = 5;*/
       /* Integer[] arr = {40,20,60,10,30,50,70};
        int v = 25;*/

        Integer[] arr = {4,2,7,1,3,null,null,null,null,null,null};
        int v = 5;
        TreeNode node1 = TreeNode.buildTree(arr);
        TreeNode.print(node1);

        TreeNode node = solution701.insertIntoBST(node1, v);
        TreeNode.print(node);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (temp != null) {
            int val1 = temp.val;
            TreeNode node;
            if (val > val1) {
                node = temp.right;
                if (node == null) {
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            } else {
                node = temp.left;
                if (node == null) {
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }

        }
        return root;
    }
}
