package com.trip.algorithm.leet.some.leet2312;

import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;

public class Solution2415 {
    public static void main(String[] args) {
        Solution2415 solution2415 = new Solution2415();
        Integer[] arr = {2, 3, 5, 8, 13, 21, 34};
        TreeNode treeNode1 = TreeNode.buildTree(arr);
        TreeNode.print(treeNode1);
        TreeNode treeNode = solution2415.reverseOddLevels(treeNode1);
        TreeNode.print(treeNode);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        int index = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            if (index % 2 == 0) {
                int l = 0;
                int r = size - 1;
                while (l <= r) {
                    TreeNode treeNode = list.get(l);
                    TreeNode treeNode1 = list.get(r);
                    if (treeNode.left != null) {
                        int leftVal = treeNode.left.val;
                        int rightVal = treeNode.right.val;

                        treeNode.left.val = treeNode1.right.val;
                        treeNode.right.val = treeNode1.left.val;
                        treeNode1.left.val = rightVal;
                        treeNode1.right.val = leftVal;
                    }
                    l++;
                    r--;
                }
            }
            while (size > 0) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode.left != null && treeNode.right != null) {
                    list.addLast(treeNode.left);
                    list.addLast(treeNode.right);
                }
                size--;
            }
            index++;
        }
        return root;
    }
}
