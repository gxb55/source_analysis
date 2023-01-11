package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年12月03日 20:25:00
 */
public class Solution236 {
    public static void main(String[] args) {
/**
 * [3,5,1,6,2,0,8,null,null,7,4]
 * 5
 * 4
 */

        Solution236 solution236 = new Solution236();
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode node1 = TreeNode.buildTree(arr);
        TreeNode.print(node1);
        int v = 5;
        int u = 8;
        TreeNode node = solution236.lowestCommonAncestor(node1, new TreeNode(v), new TreeNode(u));
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q);
    }

    private TreeNode process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode process = process(root.left, p, q);
        TreeNode process1 = process(root.right, p, q);
        if(process1!=null&&process!=null){
            return root;
        }else if(process1==null&&process!=null){
            return process;
        }else if(process1!=null&&process==null){
            return process1;
        }
        return null;
    }
}
