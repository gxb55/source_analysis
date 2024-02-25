package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2476 {
    public static void main(String[] args) {
       // demo1();
        Integer[] arr = {1, 2, 3};
        Solution2476 s = new Solution2476();
        List<Integer> list = new ArrayList<>();
        s.process(TreeNode.buildTree(arr),list);
    }

    private static void demo1() {
        Integer[] arr = {19, 3, 20, 2, 10, null, null, 1, null, 5, 15, null, null, 4, 6};
        Solution2476 s = new Solution2476();
        List<Integer> list = Arrays.asList(143265, 20, 19, 172253, 562096, 330190, 474166, 460360, 929962, 2);
        List<List<Integer>> list1 = s.closestNodes(TreeNode.buildTree(arr), list);
        list1.stream().forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        List<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            arrayList.add(new int[]{i, queries.get(i), -1, -1});
        }
        arrayList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        process(root, list);
        int curIndex = 0;
        for (int i = 0; i < list.size() && curIndex < arrayList.size(); i++) {
            Integer i1 = list.get(i);
            int[] ints = arrayList.get(curIndex);
            int val = ints[1];
            if (i1 == val) {
                ints[2] = val;
                ints[3] = val;
            } else if (i1 > val) {
                if (i > 0) {
                    ints[2] = list.get(i - 1);
                }
                ints[3] = i1;
                curIndex++;
                i--;
            }
        }
        for (int i = curIndex; i < arrayList.size(); i++) {
            arrayList.get(i)[2] = list.get(list.size() - 1);
        }
        List<List<Integer>> collect = arrayList.stream().sorted((x, y) -> x[0] > y[0] ? 1 : -1).map(x -> Arrays.asList(x[2], x[3])).collect(Collectors.toList());

        return collect;
    }

    private void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 这里
        System.out.println("V1:"+root.val);
        process(root.left, list);
        System.out.println("V2:"+root.val);
        // 这里
        list.add(root.val);
        process(root.right, list);
        // 这里
        System.out.println("V3:"+root.val);
    }
}
