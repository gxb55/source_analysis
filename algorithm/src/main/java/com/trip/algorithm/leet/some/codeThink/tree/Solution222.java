package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月20日 17:04:00
 */
public class Solution222 {
    public static void main(String[] args) {
        Solution222 solution222 = new Solution222();
         Integer[] root = {1, 2, 3, 4, 5, 6};
      //  Integer[] root = {1};
        TreeNode node = TreeNode.buildTree(root);
        TreeNode.print(node);
        int i = solution222.countNodes1(node);
        System.out.println(i);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return count;
    }

    private boolean process(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            count = count + 1;
            return true;
        }
        boolean process = process(root.left);
        boolean process1 = process(root.right);
        if (process && process1) {
            count = count + 1;
            return true;
        } else {
            return false;
        }
    }

    int count = 0;


    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int len = 0;
        TreeNode temp = root;
        while (temp != null) {
            len++;
            temp = temp.left;
        }
        int begin = (int) Math.pow(2, len-1);
        int end = (int) (Math.pow(2, len ) - 1);
        while (begin <= end) {
            temp = root;
            int mid = begin + (end - begin) / 2;
            String s = Integer.toBinaryString(mid);
            char[] chars = s.toCharArray();
            boolean flag = false;
            for (Character character : chars) {
                if (!flag && character == '1') {
                    flag = true;
                    continue;
                }
                if (flag) {
                    if (character == '1') {
                        temp = temp.right;
                    } else {
                        temp = temp.left;
                    }
                }
            }
            if (temp != null) {
                begin = mid+1 ;
            } else {
                end = mid - 1;
            }
        }
        return begin-1;
    }
}
