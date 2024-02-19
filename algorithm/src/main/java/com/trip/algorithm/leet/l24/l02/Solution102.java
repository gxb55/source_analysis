package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/2/14 08:51
 * @description TODO
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            List<Integer> temps = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = linkedList.pollFirst();
                temps.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
                size--;
            }
            list.add(temps);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        Integer[] root = {3, 9, 20, null, null, 15, 7};
        solution102.levelOrder(TreeNode.buildTree(root));
    }
}
