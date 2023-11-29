package com.trip.algorithm.leet.some.leet2311;


import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2023年11月25日 11:53:00
 */
public class Solution1457 {
    public static void main(String[] args) {
        Solution1457 solution1457 = new Solution1457();
        Integer[] arr = {2, 3, 1, 3, 1, null, 1};
        TreeNode treeNode = TreeNode.buildTree(arr);
        int i = solution1457.pseudoPalindromicPaths(treeNode);
        System.out.println(i);
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] p =new int[10];
        process(root, p);
        return count;
    }

    private int check(int[] p) {
        int cnt = 0;
        for (int x : p) {
            cnt += x;
        }
        return cnt <= 1 ? 1 : 0;
    }

    int count = 0;

    private void process(TreeNode root, int[] p) {
        if (root == null) {
            return;
        }
        p[root.val]=p[root.val]^1;
        if (root.left == null && root.right == null) {
            int check = check(p);
            count += check;
        }
        if (root.left != null) {
            process(root.left, p);
            p[root.left.val]=p[root.left.val]^1;
        }
        if (root.right != null) {
            process(root.right, p);
            p[root.right.val]=p[root.right.val]^1;
        }
    }
}
