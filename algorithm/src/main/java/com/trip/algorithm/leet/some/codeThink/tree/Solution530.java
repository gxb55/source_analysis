package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年12月03日 17:48:00
 */
public class Solution530 {
    public static void main(String[] args) {
        // Integer[] arr = {4, -57, -57, null, 67, 67, null, null, -97, -97};
        //Integer[] arr = {2, 1, 3};
        // Integer[] arr = {5, 4, 6, null, null, 3, 7};
        Integer[] arr = {236, 104, 701, null, 227, null, 911};
        // Integer[] arr = {5, 1, 4, null, null, 3, 6};
        //Integer[] arr = {2, 2, 2};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        Solution530 s = new Solution530();
        int minimumDifference = s.getMinimumDifference(node);
        System.out.println(minimumDifference);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        int cur = list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            Integer val = list.get(i);
            min = Math.min(min, Math.abs(cur - val));
            cur = val;
        }
        return min;
    }

    private void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }
}
