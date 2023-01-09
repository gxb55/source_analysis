package com.trip.algorithm.codethink.treecode;


import com.trip.study.leetcode.TreeNode;

/**
 * @author xbguo
 * @date 2022/12/1 16:20
 * @description Solution700
 */
public class Solution700 {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp =root;
        while (temp!=null){
            int curVal = temp.val;
            if(curVal==val){
                return temp;
            }else if(curVal>val){
                temp=temp.left;
            }else{
                temp=temp.right;
            }
        }
        return null;
    }
}
