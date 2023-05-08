package com.trip.algorithm.leet.some.leet2304;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/4/18 18:48
 * root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 */
public class Solution1026 {
    public static void main(String[] args) {
        Solution1026 solution1026 = new Solution1026();
      //  Integer[] root = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
      //  Integer[] root = {1,null,2,null,0,3};
        Integer[] root = {7,5,12,11,0,2,null,4,17,6,19,null,16,18,null,null,null,null,9,14,10,null,null,null,null,null,null,null,null,3,1,null,null,8,null,13,null,null,15};
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.show(treeNode);
        int i = solution1026.maxAncestorDiff(treeNode);
        System.out.println(i);
    }

    public int maxAncestorDiff(TreeNode root) {
        process(root);
        return max;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        int[] ints = process1(root);
        max=Math.max(max, Math.abs(root.val - ints[0]));
        max=Math.max(max, Math.abs(root.val - ints[1]));
        process(root.left);
        process(root.right);
    }

    private int[] process1(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] ints = process1(root.left);
        int[] ints1 = process1(root.right);
        if (ints1 == null && ints == null) {
            return new int[]{root.val, root.val};
        } else if (ints1 == null && ints != null) {
            return new int[]{Math.min(ints[0], root.val), Math.max(ints[1], root.val)};
        } else if (ints1 != null && ints == null) {
            return new int[]{Math.min(ints1[0], root.val), Math.max(ints1[1], root.val)};
        } else {
            int min = Math.min(Math.min(root.val, ints[0]), ints1[0]);
            int max = Math.max(Math.max(root.val, ints[1]), ints1[1]);
            return new int[]{min, max};
        }
    }

    int max = -1;
}
