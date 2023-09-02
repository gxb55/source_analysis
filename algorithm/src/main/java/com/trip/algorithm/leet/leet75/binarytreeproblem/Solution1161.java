package com.trip.algorithm.leet.leet75.binarytreeproblem;

import com.trip.algorithm.base.TreeNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年08月29日 22:23:00
 */
public class Solution1161 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3};
        TreeNode treeNode = TreeNode.buildTree(arr);
        Solution1161 solution1161 = new Solution1161();
        int i = solution1161.maxLevelSum(treeNode);
        System.out.println(i);
    }

    public int maxLevelSum(TreeNode root) {
        process(root, 1);
        Integer integer = map.keySet().stream().max(Comparator.comparing(x -> x)).get();
        Integer z = map.values().stream().max(Comparator.comparing(x -> x)).get();
        for (int i = 1; i <= integer; i++) {
            if (map.get(i).equals(z)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * @param root
     * @param depth 深度
     */
    private void process(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        int val = root.val;
        map.put(depth, map.getOrDefault(depth, 0) + val);
        process(root.left, depth + 1);
        process(root.right, depth + 1);
    }

    Map<Integer, Integer> map = new HashMap<>();
}
