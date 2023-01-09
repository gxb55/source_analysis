package com.trip.algorithm.leet.some.leet09;

import com.trip.study.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/9/2  17:38
 * @description Solution257
 */
public class Solution257 {
    public static void main(String[] args) {
        Solution257 solution257 = new Solution257();
        // Integer[] arr={1,2,3};
        //Integer[] arr = {1, 2, 3, null, 5};
         Integer[] arr={1};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.show(treeNode);
        List<String> list = solution257.binaryTreePaths(treeNode);
        System.out.println(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        dfs(root, tempList, list);
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    private void dfs(TreeNode root, List<Integer> tempList, List<String> list) {
        if (root == null) {
            return;
        }
        tempList.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : tempList) {
                stringBuilder.append(integer).append("->");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            list.add(stringBuilder.toString());
        }
        dfs(root.left, tempList, list);
        dfs(root.right, tempList, list);
        tempList.remove(tempList.size() - 1);
    }
}
