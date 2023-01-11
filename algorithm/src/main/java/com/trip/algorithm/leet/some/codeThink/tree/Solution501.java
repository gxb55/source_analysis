package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年12月03日 18:06:00
 */
public class Solution501 {
    public static void main(String[] args) {
        Solution501 solution501 = new Solution501();
        // Integer[] arr = {1, null, 2, 2};
        // Integer[] arr = {1};
        Integer[] arr = {1, null, 2};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        int[] mode = solution501.findMode(node);
        System.out.println(Arrays.toString(mode));
    }


    Integer max = null;

    public int[] findMode1(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        process1(map, root);
        List<Integer> collect = map.entrySet().stream().filter(x -> x.getValue() == max).map(x -> x.getKey()).collect(Collectors.toList());
        int size = collect.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = collect.get(i);
        }
        return arr;
    }

    private void process1(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) {
            return;
        }
        process1(map, root.left);
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        max = Math.max(map.get(root.val), max);
        process1(map, root.right);
    }


    public int[] findMode(TreeNode root) {
        process(root);
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    List<Integer> list = new ArrayList<>();
    Integer count = null;
    Integer maxCount = 0;
    TreeNode preNode = null;


    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        int curVal = root.val;
        if (count == null) {
            count = 1;
        } else if (preNode.val == curVal) {
            count = count + 1;
        } else if (preNode.val != curVal) {
            count = 1;
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(curVal);
        } else if (count.equals(maxCount)) {
            list.add(curVal);
        }
        preNode = root;
        process(root.right);
    }
}
