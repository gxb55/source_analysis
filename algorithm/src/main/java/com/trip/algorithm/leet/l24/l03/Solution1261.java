package com.trip.algorithm.leet.l24.l03;

import com.trip.algorithm.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xbguo
 * @date 2024/3/13 19:59
 * @description TODO
 */
public class Solution1261 {
    public static void main(String[] args) {
        String a="500|50";
        String[] split = a.split("\\|");
        System.out.println(split.length);
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

}

class FindElements {
    Set<Integer> list = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        process(root);
    }

    private void process(TreeNode root) {
        list.add(root.val);
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            process(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            process(root.right);
        }
    }

    public boolean find(int target) {
        return list.contains(target);
    }
}