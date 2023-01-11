package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年11月20日 18:18:00
 */
public class Solution257 {
    public static void main(String[] args) {
        Solution257 solution110 = new Solution257();
        //Integer[] arr= {3,9,20,null,null,15,7};
        Integer[] arr = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode node = TreeNode.buildTree(arr);
        TreeNode.print(node);
        List<String> list = solution110.binaryTreePaths(node);
        System.out.println(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        process(root, list, "");
        return list;
    }

    private void process(TreeNode root, List<String> list, String res) {
        if (root == null) {
            return;
        }
        String s = "";
        if (res.equals("")) {
            s = String.valueOf(root.val);
        } else {
            s = res + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            list.add(s);
        } else {
            process(root.left, list, s);
            process(root.right, list, s);
        }
    }
}
