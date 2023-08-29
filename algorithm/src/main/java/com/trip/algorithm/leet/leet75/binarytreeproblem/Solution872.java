package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年08月27日 16:55:00
 * root1 = [1,2,3], root2 = [1,3,2]
 */
public class Solution872 {
    public static void main(String[] args) {

        Solution872 solution872 = new Solution872();
       /* Integer[] root1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] root2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}; */

        Integer[] root1 = {1,2,3};
        Integer[] root2 = {1,3,2};
        boolean b = solution872.leafSimilar(TreeNode.buildTree(root1), TreeNode.buildTree(root2));
        System.out.println(b);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        process(root1, stringBuilder1);
        process(root2, stringBuilder2);
        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }

    private void process(TreeNode root, StringBuilder stringBuilder1) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            stringBuilder1.append(root.val + "_");
        }
        process(root.left, stringBuilder1);
        process(root.right, stringBuilder1);
    }
}
