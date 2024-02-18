package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.Optional;

/**
 * @author xbguo
 * @date 2024/2/7 15:02
 */
public class Solution2641 {
    public static void main(String[] args) {
        Solution2641 solution2641 = new Solution2641();
      //  Integer[] root = {5, 4, 9, 1, 10, null, 7};
        Integer[] root = {3,1,2};
        TreeNode treeNode = solution2641.replaceValueInTree(TreeNode.buildTree(root));
        TreeNode.print(treeNode);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        root.val = 0;
        while (!list.isEmpty()) {
            int size = list.size();

            int sum = 0;
            for (TreeNode treeNode : list) {
                sum += Optional.ofNullable(treeNode.left).map(x -> x.val).orElse(0);
                sum += Optional.ofNullable(treeNode.right).map(x -> x.val).orElse(0);
            }
            for (int i = 0; i < size; i++) {
                int t = sum;
                TreeNode treeNode = list.pollFirst();
                int leftVal = Optional.ofNullable(treeNode.left).map(x -> x.val).orElse(0);
                int rightVal = Optional.ofNullable(treeNode.right).map(x -> x.val).orElse(0);
                if (treeNode.left != null) {
                    t = t - leftVal;
                    t = t - rightVal;

                    treeNode.left.val = t;
                    list.addLast(treeNode.left);
                }
                t = sum;
                if (treeNode.right != null) {
                    t = t - leftVal;
                    t = t - rightVal;
                    treeNode.right.val = t;
                    list.addLast(treeNode.right);
                }

            }
        }
        return root;
    }
}
