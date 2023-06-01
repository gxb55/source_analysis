package com.trip.algorithm.leet.some.leet2305;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/5/30 09:47
 */
public class Solution1110 {
    public static void main(String[] args) {
        Solution1110 solution1110 = new Solution1110();
        Integer[] root = {1, 2, 3, 4, 5, 6, 7};
        int[] to_delete = {1, 3, 5};
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.print(treeNode);
        List<TreeNode> list = solution1110.delNodes(treeNode, to_delete);
        list.forEach(x -> {
            TreeNode.print(x);
        });

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete.length == 0) {
            return Collections.singletonList(root);
        }
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        List<Integer> delList = new ArrayList<>();
        Arrays.stream(to_delete).forEach(x -> delList.add(x));
        list.add(root);
        process(root, null, "", list, delList);
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode == null || delList.contains(treeNode.val)) {
                continue;
            }
            res.add(treeNode);
        }
        return res;
    }

    private void process(TreeNode root, TreeNode parent, String f, List<TreeNode> list, List<Integer> delList) {
        if (root == null) {
            return;
        }
        if (delList.contains(root.val)) {
            if (parent == null) {
            } else if (f.equals("L")) {
                parent.left = null;
            } else if (f.equals("R")) {
                parent.right = null;
            }
            list.add(root.left);
            list.add(root.right);
        }
        process(root.left, root, "L", list, delList);
        process(root.right, root, "R", list, delList);
    }


    Set<Integer> set = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            root = null;
        }
        return root;
    }

    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
        for (int d : to_delete) {
            set.add(d);
        }
        if (!set.contains(root.val)) {
            ans.add(root);
        }
        dfs(root);
        return ans;
    }
}
