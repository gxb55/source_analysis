package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/10/18 14:17
 */
public class Solution102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode treeNode = linkedList.pollFirst();
                tempList.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
