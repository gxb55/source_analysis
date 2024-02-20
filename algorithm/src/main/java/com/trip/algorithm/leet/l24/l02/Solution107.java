package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution107 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<List<Integer>> resultList = new ArrayList<>();

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = linkedList.pollFirst();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
                size--;
            }
            list.add(temp);
        }

        int len = list.size();
        for (int i = len - 1; i >= 0; i--) {
            resultList.add(list.get(i));
        }
        return resultList;

    }
}
