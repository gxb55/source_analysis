package com.trip.algorithm.leet.some.leet09;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/9/5  9:44
 * @description TODO
 */
public class Solution652 {
    public static void main(String[] args) {
        Solution652 solution652 = new Solution652();
          Integer[]root = {1,2,3,4,null,2,4,null,null,4};
        //  Integer[]root = {2,1,1};
        //Integer[] root = {0, 0, 0, 0, null, null, 0, null, null, null, 0};
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.show(treeNode);
        List<TreeNode> duplicateSubtrees = solution652.findDuplicateSubtrees1(treeNode);
        System.out.println(duplicateSubtrees);
    }

    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, TreeNode> map1 = new HashMap<>();
        dfs(root, map, map1);
        List<TreeNode> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(map1.get(entry.getKey()));
            }
        }
        return list;
    }

    private String dfs(TreeNode root, Map<String, Integer> map, Map<String, TreeNode> map1) {
        if (root == null) {
            return " ";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append(root.val).append(")").append("(");
        stringBuilder.append(dfs(root.left, map, map1)).append(")");
        stringBuilder.append("(").append(dfs(root.right, map, map1)).append(")");
        String s = stringBuilder.toString();
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        map1.put(s, root);
        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Node, Integer> map = new HashMap<>();
        process(map, root);
        List<TreeNode> list = new ArrayList<>();

        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey().list.get(0));
            }
        }
        return list;
    }

    private void process(Map<Node, Integer> map, TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> leftList = new ArrayList<>();
        buildList(root, leftList);
        Node node = new Node(leftList);
        if (map.containsKey(node)) {
            map.put(node, map.get(node) + 1);
        } else {
            map.put(node, 1);
        }
        process(map, root.left);
        process(map, root.right);
    }

    private void buildList(TreeNode root, List<TreeNode> leftList) {
        if (root == null) {
            return;
        }
        leftList.add(root);
        buildList(root.left, leftList);
        buildList(root.right, leftList);
    }

    static class Node {
        List<TreeNode> list;

        public Node(List<TreeNode> list) {
            this.list = list;
        }

        public Node() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            if (node.list.size() == list.size()) {
                TreeNode treeNode = list.get(0);
                TreeNode treeNode1 = node.list.get(0);
                while (true) {
                    return check(treeNode1, treeNode);
                }
            }

            return Objects.equals(list, node.list);
        }

        private boolean check(TreeNode treeNode1, TreeNode treeNode) {
            if (treeNode1 == null && treeNode == null) {
                return true;
            }
            if (treeNode1 != null && treeNode == null) {
                return false;
            }
            if (treeNode1 == null && treeNode != null) {
                return false;
            }
            if (treeNode1 != null && treeNode != null && treeNode1.val != treeNode.val) {
                return false;
            }
            return check(treeNode1.left, treeNode.left) && check(treeNode1.right, treeNode.right);
        }

        @Override
        public int hashCode() {
            List<Integer> collect1 = list.stream().map(x -> x.val).collect(Collectors.toList());
            return Objects.hash(collect1);
        }
    }

}
