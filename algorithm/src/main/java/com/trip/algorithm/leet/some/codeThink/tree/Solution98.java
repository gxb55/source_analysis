package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年12月03日 11:04:00
 */
public class Solution98 {
    public static void main(String[] args) {
        // Integer[] arr = {4, -57, -57, null, 67, 67, null, null, -97, -97};
        //Integer[] arr = {2, 1, 3};
        Integer[] arr = {5, 4, 6, null, null, 3, 7};
        // Integer[] arr = {5, 1, 4, null, null, 3, 6};
        //Integer[] arr = {2, 2, 2};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        Solution98 solution98 = new Solution98();
        boolean symmetric = solution98.isValidBST(node);
        System.out.println(symmetric);
        System.out.println("==========================");
        System.out.println(solution98.isValidBST1(node));
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        Integer cur = null;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                if (cur == null) {
                    cur = temp.val;
                } else if (cur >= temp.val) {
                    return false;
                } else {
                    cur = temp.val;
                }
                temp = temp.right;
            }
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return process(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean process(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        if(min!=null&&root.val<=min){
            return false;
        }
        if(max!=null&&root.val>=max){
            return false;
        }
        return process(root.left,min, (long) root.val)&& process(root.right, (long) root.val,max);
    }
}
