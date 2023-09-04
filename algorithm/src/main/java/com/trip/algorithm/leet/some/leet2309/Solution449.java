package com.trip.algorithm.leet.some.leet2309;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/9/4 10:25
 * <p>
 * 层级遍历，层级恢复，遍历过程中，只会处理一次，空的节点
 */
public class Solution449 {
    public static void main(String[] args) {
        Solution449 solution449 = new Solution449();
        Integer[] arr = {2, 1, 3, 4, 5, null, 6, 8};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.print(treeNode);

        String serialize = solution449.serialize1(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = solution449.deserialize1(serialize);
        TreeNode.print(deserialize);
    }

    public String serialize1(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        process(root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 根左右
     */
    private void process(TreeNode root, StringBuilder stringBuilder) {
        int val = root.val;
        stringBuilder.append(val).append(",");
        if (root.left == null) {
            stringBuilder.append(-1).append(",");
        } else {
            process(root.left, stringBuilder);
        }
        if (root.right == null) {
            stringBuilder.append(-1).append(",");
        } else {
            process(root.right, stringBuilder);
        }
    }

    public TreeNode deserialize1(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        List<String> list = Arrays.stream(data.split(",")).filter(x -> !x.equals("")).collect(Collectors.toList());
        return process2(list);

    }

    private TreeNode process2(List<String> list) {
        if(list.size()==0){
            return null;
        }
        String remove = list.remove(0);
        if ("-1".equals(remove)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(remove));
        treeNode.left = process2(list);
        treeNode.right = process2(list);
        return treeNode;
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            for (TreeNode treeNode : linkedList) {
                if (treeNode == null) {
                    stringBuilder.append("-1").append(",");
                } else {
                    stringBuilder.append(treeNode.val).append(",");
                }
            }
            stringBuilder.append("#");
            int size = linkedList.size();
            while (size > 0) {
                size--;
                TreeNode treeNode = linkedList.pollFirst();
                if (treeNode == null) {
                    continue;
                }
                linkedList.addLast(treeNode.left);
                linkedList.addLast(treeNode.right);
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split("#");
        List<List<String>> list = new ArrayList<>();
        for (String str : split) {
            String[] split1 = str.split(",");
            list.add(List.of(split1));
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(list.get(0).get(0)));
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(treeNode);
        for (int i = 1; i < list.size(); i++) {
            int index = 0;
            List<TreeNode> temp = new ArrayList<>();
            for (int j = 0; j < list.get(i).size() - 1; j++) {
                TreeNode treeNode1 = list1.get(index);
                String s1 = list.get(i).get(j);
                String s2 = list.get(i).get(++j);
                if (!s1.equals("-1")) {
                    TreeNode treeNode2 = new TreeNode(Integer.valueOf(s1));
                    temp.add(treeNode2);
                    treeNode1.left = treeNode2;
                }
                if (!s2.equals("-1")) {
                    TreeNode treeNode2 = new TreeNode(Integer.valueOf(s2));
                    temp.add(treeNode2);
                    treeNode1.right = treeNode2;
                }
                index++;
            }
            list1 = temp;
        }
        return treeNode;
    }
}
