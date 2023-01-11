package com.trip.algorithm.leet.some.codeThink.tree;

import com.trip.algorithm.leet.some.history.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年11月29日 22:22:00
 */
public class Solution112 {
    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
       /* Integer[] root = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int targetSum = 22; */
       /* Integer[] root = {1, 2 };
        int targetSum = 1;*/

        Integer[] root = {1,2,null,3,null,4,null,5 };
        int targetSum = 6;
        TreeNode node = TreeNode.buildTree(root);
        TreeNode.print(node);

        boolean b = solution112.hasPathSum(node, targetSum);
        System.out.println(b);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }else if(root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        Integer cur=null;
        return process(root,targetSum,cur,0);
    }

    private boolean process(TreeNode root, int targetSum, Integer cur, int len) {
      /*  if(root==null&&cur!=null&&cur==targetSum&&len>1){
            return true;
        }*/
        if(root==null){
            return false;
        }
        if(cur==null){
            cur=0;
        }
        if(root.left==null&&root.right==null&&(cur+root.val==targetSum)){
            return true;
        }
        return process(root.left,targetSum,cur+root.val, len+1)||process(root.right,targetSum,cur+root.val, len+1);
    }

}
