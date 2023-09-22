package com.trip.algorithm.leet.some.leet2309;

import com.trip.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/9/18 10:45
 */
public class Solution337 {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 3, null, 3, null, 1};
        Solution337 solution337 = new Solution337();
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.print(treeNode);
        int rob = solution337.rob(treeNode);
        System.out.println(rob);
    }


    public int rob(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int res = process1(root, false);
        int res2 = process1(root, true) + root.val;
        return Math.max(res2, res);
    }

    Map<String, Integer> map = new HashMap<>();

    private int process1(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root.toString() + flag)) {
            return map.get(root.toString() + flag);
        }
        if (flag) {
            int p1 = 0, p2 = 0;
            if (root.left != null) {
                p1 = process1(root.left, false);
            }
            if (root.right != null) {
                p2 = process1(root.right, false);
            }
            return p2 + p1;
        }
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        if (root.left != null) {
            p1 = process1(root.left, false);
            p2 = process1(root.left, true) + root.left.val;
        }
        if (root.right != null) {
            p3 = process1(root.right, false);
            p4 = process1(root.right, true) + root.right.val;
        }
        int r1 = Math.max(p1, p2);
        int r2 = Math.max(p3, p4);
        map.put(root.toString() + flag, r1 + r2);
        return r1 + r2;
    }



}


