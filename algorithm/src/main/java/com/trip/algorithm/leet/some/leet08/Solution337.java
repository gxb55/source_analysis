package com.trip.algorithm.leet.some.leet08;

import com.trip.study.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/15  19:02
 * @description Solution337
 */
public class Solution337 {
    public static void main(String[] args) {
        // Integer[] root = {3, 4, 5, 1, 3, null, 1};
        // Integer[] root = {4, 1, null, 2, null, 3};
        Integer[] root = {1, null, 4, 3, null, null, 2};
        TreeNode node = TreeNode.buildTree(root);
        TreeNode.show(node);
        Solution337 solution337 = new Solution337();
        int rob = solution337.rob(node);
        System.out.println(rob);

    }

    public int rob(TreeNode root) {
        int process = process(root, true, true);
        return process;
    }

    Map<TreeNode, Map<String, Integer>> sumMap = new HashMap<>();

    /**
     * @param root
     * @param flag 当前结点是否可选
     * @return
     */
    private int process(TreeNode root, boolean flag, boolean chirdFlag) {
        if (root == null) {
            return 0;
        }
        if (sumMap.get(root) != null) {
            Integer integer = sumMap.get(root).get(flag + "_" + chirdFlag);
            if (integer != null) {
                return integer;
            }
        }
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;
        // 当前结点可选
        if (flag) {
            p1 = process(root.left, false, true) + process(root.right, false, true) + Integer.valueOf(String.valueOf(root.v));
            if (root.left != null) {
                p2 = process(root.left, false, false) + process(root.right, true, true) + Integer.valueOf(String.valueOf(root.left.v));
            }
            if (root.right != null) {
                p3 = process(root.left, true, true) + process(root.right, false, false) + Integer.valueOf(String.valueOf(root.right.v));
            }
            p6 = process(root.left, true, true) + process(root.right, true, true);
        } else {
            if (chirdFlag) {
                if (root.left != null) {
                    p4 = process(root.left, false, false) + process(root.right, false, true) + Integer.valueOf(String.valueOf(root.left.v));
                }
                if (root.right != null) {
                    p5 = process(root.left, false, true) + process(root.right, false, false) + Integer.valueOf(String.valueOf(root.right.v));
                }
                p6 = process(root.left, true, true) + process(root.right, true, true);
            }
        }
        int max1 = Math.max(p1, p2);
        int max2 = Math.max(p3, p4);
        int max = Math.max(max1, max2);
        int max3 = Math.max(Math.max(max, p5), p6);
        Map<String, Integer> map = sumMap.get(root);
        if (map != null) {
            map.put(flag + "_" + chirdFlag, max3);
        } else {
            map = new HashMap<>();
            map.put(flag + "_" + chirdFlag, max3);
            sumMap.put(root, map);
        }
        return max3;
    }
}
