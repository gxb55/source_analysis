package com.trip.algorithm.leet.some.leet08;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/8/17  15:02
 * @description 1302. 层数最深叶子节点的和
 */
public class Solution1302 {
    public static void main(String[] args) {
        Solution1302 solution1302 = new Solution1302();
        Integer[] root = { 1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.show(treeNode);
        int i = solution1302.deepestLeavesSum(treeNode);
        System.out.println(i);
    }

    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<TreeNode> result = new ArrayList<>();
        while (!list.isEmpty()) {
            result.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
                result.add(treeNode);
            }
        }
        int sum = 0;
        for (TreeNode v : result) {
            sum = sum + Integer.valueOf(String.valueOf(v.getVal()));
        }
        return sum;
    }
}
