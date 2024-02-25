package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/2/21 19:03
 */
public class Solution106 {
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = solution106.buildTree(inorder, postorder);
        TreeNode.print(treeNode);
    }

    /**
     * 左根右
     * 左右根
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return process(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    private TreeNode process(int[] inorder, int i, int j, int[] postorder, int i1, int j1, Map<Integer, Integer> map) {
        if (i == j) {
            return new TreeNode(inorder[i]);
        }
        if (i > j) {
            return null;
        }
        int val = postorder[j1];
        TreeNode treeNode = new TreeNode(val);
        Integer index = map.get(val);
        int len = index - i;
        treeNode.left = process(inorder, i, index - 1, postorder, i1, i1 + len - 1, map);
        treeNode.right = process(inorder, index + 1, j, postorder, i1 + len , j1-1, map);
        return treeNode;
    }
}
