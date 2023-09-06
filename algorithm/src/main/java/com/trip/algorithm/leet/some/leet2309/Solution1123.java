package com.trip.algorithm.leet.some.leet2309;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/9/6 10:38
 */
public class Solution1123 {
    public static void main(String[] args) {
        //  Integer[] root = {0,1,3,null,2};
        Integer[] root = {1, 3, 2, 14, 10, 4, 6, null, null, null, 11, 8, 5, 9, 7, null, null, 15, null, 16, 13, null, null, 12};
        // Integer[] root = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Solution1123 solution1123 = new Solution1123();
        TreeNode treeNode1 = TreeNode.buildTree(root);
        TreeNode treeNode = solution1123.lcaDeepestLeaves(treeNode1);
        TreeNode.print(treeNode1);
        TreeNode.print(treeNode);
    }



    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        process1(root, 0);
        List<TreeNode> list = map.get(max);
        if (list.size() == 1) {
            return list.get(0);
        }
        process2(root, list);
        return res;
    }
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    int max = 0;
    TreeNode res = null;
    private void process2(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>(list);
        getRes(root, treeNodes);
        if (treeNodes.size() == 0) {
            res = root;
        }
        process2(root.left, list);
        process2(root.right, list);
    }

    private void getRes(TreeNode root, ArrayList<TreeNode> treeNodes) {
        if (root == null) {
            return;
        }
        treeNodes.remove(root);
        getRes(root.left, treeNodes);
        getRes(root.right, treeNodes);
    }

    private void process1(TreeNode root, int dept) {
        if (root == null) {
            return;
        }
        List<TreeNode> orDefault = map.getOrDefault(dept, new ArrayList<>());
        orDefault.add(root);
        map.put(dept, orDefault);
        max = Math.max(max, dept);
        process1(root.left, dept + 1);
        process1(root.right, dept + 1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        process(root, temp, list);
        List<List<TreeNode>> collect = list.stream().sorted((x, y) -> y.size() - x.size()).collect(Collectors.toList());
        List<List<TreeNode>> res = new ArrayList<>();
        List<TreeNode> list1 = collect.get(0);
        int size = list1.size();
        res.add(list1);
        int index = 1;
        while (index < collect.size() && size == collect.get(index).size()) {
            res.add(collect.get(index));
            index++;
        }
        if (res.size() == 1) {
            return list1.get(list1.size() - 1);
        }

        for (int i = list1.size() - 1; i >= 0; i--) {
            TreeNode treeNode = list1.get(i);
            int finalI = i;
            boolean b = res.stream().allMatch(x -> x.get(finalI).equals(treeNode));
            if (b) {
                return treeNode;
            }
        }
        return null;
    }

    private void process(TreeNode root, List<TreeNode> temp, List<List<TreeNode>> list) {

        temp.add(root);
        list.add(new ArrayList<>(temp));
        if (root.left != null) {
            process(root.left, temp, list);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            process(root.right, temp, list);
            temp.remove(temp.size() - 1);
        }
    }
}
