package com.trip.algorithm.leet.some.Leet2308;

import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2023/8/25 10:45
 */
public class Solution1448 {
    public static void main(String[] args) {
       // Integer[] arr = new Integer[]{3, 1, 4, 3, null, 1, 5};
       // Integer[] arr = new Integer[]{3,3,null,4,2};
        Integer[] arr = new Integer[]{1};
        TreeNode treeNode = TreeNode.buildTree(arr);
        Solution1448 solution1448 = new Solution1448();
        int i = solution1448.goodNodes(treeNode);
        System.out.println(i);
    }

    public int goodNodes(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        process(root, list);
        return count;
    }

    private void process(TreeNode root, LinkedList<Integer> list) {
        int val = root.val;
        list.addLast(val);
        Integer integer = list.stream().max(Integer::compareTo).get();
        if (val >= integer) {
            count++;
        }
        if (root.left != null) {
            process(root.left, list);
            list.pollLast();
        }
        if (root.right != null) {
            process(root.right, list);
            list.pollLast();
        }
    }

    int count = 0;
}
