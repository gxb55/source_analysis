package com.trip.algorithm.leet.some.codeThink.tree;


import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年11月19日 18:57:00
 */
public class Solution101 {
    public static void main(String[] args) {
        //Integer[] arr = {1, 2, 2, null, 3, null, 3};
        // Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        Integer[] arr = {4, -57, -57, null, 67, 67, null, null, -97, -97};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        Solution101 solution101 = new Solution101();
        boolean symmetric = solution101.isSymmetric1(node);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            if (!check(list)) {
                return false;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pollFirst();
                if (node != null) {
                    list.addLast(node.left);
                    list.addLast(node.right);
                }
            }
        }
        return true;
    }

    private boolean check(List<TreeNode> list) {
        int begin = 0;
        int end = list.size() - 1;
        while (begin <= end) {
            boolean flag = (list.get(begin) != null && list.get(end) == null) ||
                    (list.get(begin) == null && list.get(end) != null);
            if (flag) {
                return false;
            }
            if (list.get(begin) == null && list.get(end) == null) {
                begin++;
                end--;
                continue;
            }
            if (list.get(begin).val != list.get(end).val) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
