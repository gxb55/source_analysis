package com.trip.algorithm.leet.l24.l04;

import com.trip.algorithm.base.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/4/30 15:55
 */
public class Solution2385 {

    public static void main(String[] args) {
        Integer[] root = {1, 5, 3, null, 4, 10, 6, 9, 2};
        int start = 3;
        TreeNode treeNode = TreeNode.buildTree(root);
        Solution2385 solution2385 = new Solution2385();
        int i = solution2385.amountOfTime(treeNode, start);
        System.out.println(i);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        process(root, map);
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(start);
        set.add(start);
        int time = 0;
        while (!list.isEmpty()) {
            int len = list.size();
            while (len > 0) {
                len--;
                Integer integer = list.pollLast();
                Set<Integer> set1 = map.get(integer);
                set1.stream().filter(x -> !set.contains(x)).forEach(x -> {
                    list.addFirst(x);
                    set.add(x);
                });
            }
            time++;
        }
        return time;
    }

    private void process(TreeNode root, Map<Integer, Set<Integer>> map) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (root.left != null) {
            int val1 = root.left.val;
            addVal(map, val, val1);
            addVal(map, val1, val);
            process(root.left, map);
        }
        if (root.right != null) {
            int val2 = root.right.val;
            addVal(map, val, val2);
            addVal(map, val2, val);
            process(root.right, map);
        }

    }

    private void addVal(Map<Integer, Set<Integer>> map, int key, int val) {
        Set<Integer> orDefault = map.getOrDefault(key, new HashSet<>());
        orDefault.add(val);
        map.put(key, orDefault);
    }
}
