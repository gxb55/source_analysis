package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution987 {
    public static void main(String[] args) {
        Integer[] root = {3, 9, 20, null, null, 15, 7};
        Solution987 solution987 = new Solution987();
        List<List<Integer>> list = solution987.verticalTraversal(TreeNode.buildTree(root));
        list.stream().forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNodeWrapper> wrapperList = new ArrayList<>();
        LinkedList<TreeNodeWrapper> linkedList = new LinkedList<>();
        linkedList.add(new TreeNodeWrapper(root, new int[]{0, 0}));
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size > 0) {
                TreeNodeWrapper treeNodeWrapper = linkedList.pollFirst();
                wrapperList.add(treeNodeWrapper);
                int[] arr = treeNodeWrapper.arr;
                if (treeNodeWrapper.root.left != null) {
                    linkedList.addLast(new TreeNodeWrapper(treeNodeWrapper.root.left, new int[]{arr[0] + 1, arr[1] - 1}));
                }
                if (treeNodeWrapper.root.right != null) {
                    linkedList.addLast(new TreeNodeWrapper(treeNodeWrapper.root.right, new int[]{arr[0] + 1, arr[1] + 1}));
                }
                size--;
            }
        }
        wrapperList.sort((x, y) -> y.arr[1] - x.arr[1]);
        Map<Integer, List<TreeNodeWrapper>> collect = wrapperList.stream().collect(Collectors.groupingBy(x -> x.arr[1]));
        collect.entrySet().stream().sorted((x, y) -> x.getKey() - y.getKey()).forEach(x -> {
            List<Integer> integers = new ArrayList<>();
            x.getValue().sort((x1,y1)->{
                if(x1.arr[0]==y1.arr[0]){
                    return x1.root.val-y1.root.val;
                }else {
                    return x1.arr[0]-y1.arr[0];
                }
            });
            x.getValue().stream().forEach(z -> integers.add(z.root.val));

            list.add(integers);
        });
        return list;
    }

    class TreeNodeWrapper {
        public TreeNode root;
        public int[] arr;

        public TreeNodeWrapper(TreeNode root, int[] arr) {
            this.root = root;
            this.arr = arr;
        }
    }
}
