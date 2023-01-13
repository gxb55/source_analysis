package com.trip.algorithm.leet.some.codeThink.tree;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月19日 18:19:00
 */
public class Morris {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode node = TreeNode.createTreeNode(arr);
        Morris.morrisPrint(node);
    }

    public static void morrisPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode curNode = treeNode;
        TreeNode morrisRight;
        while (curNode != null) {
            System.out.println(curNode.val);
            morrisRight = curNode.left;
            if (morrisRight != null) {
                while (morrisRight.right != null && morrisRight.right != curNode) {
                    morrisRight = morrisRight.right;
                }
                if (morrisRight.right == null) {
                    morrisRight.right = curNode;
                    curNode = curNode.left;
                    continue;
                } else {
                    morrisRight.right = null;
                }
            }
            curNode = curNode.right;
        }
    }
}
