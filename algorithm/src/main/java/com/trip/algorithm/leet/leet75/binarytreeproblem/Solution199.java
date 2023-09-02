package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月29日 22:09:00
 */
public class Solution199 {
    public static void main(String[] args) {
        // Integer[] arr = new Integer[]{1, 2, 3, null, 5, null, 4};
        Integer[] arr = new Integer[]{1, null, 3};
        TreeNode treeNode = TreeNode.buildTree(arr);
        List<Integer> list = rightSideView(treeNode);
        System.out.println(list);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode treeNode = list.peekLast();
            res.add(treeNode.val);
            int len = list.size();
            while (len > 0) {
                TreeNode treeNode1 = list.pollFirst();
                if (treeNode1.left != null) {
                    list.addLast(treeNode1.left);
                }
                if (treeNode1.right != null) {
                    list.addLast(treeNode1.right);
                }
                len--;
            }
        }
        return res;
    }
}
