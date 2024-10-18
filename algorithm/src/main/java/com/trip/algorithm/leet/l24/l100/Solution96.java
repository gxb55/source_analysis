package com.trip.algorithm.leet.l24.l100;

import com.trip.algorithm.base.TreeNode;

import java.util.Objects;

/**
 * @author xbguo
 * @date 2024/10/18 15:36
 * @description TODO
 */
public class Solution96 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return process(root, null, null, null);
    }


    private boolean process(TreeNode root, String step, Integer left, Integer right) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (root.left != null) {
            if (root.left.val >= val) {
                return false;
            }
            if(left!=null){
                if(root.left.val <= left){
                    return false;
                }
            }
            if(right!=null){
                if(root.left.val >= right){
                    return false;
                }
            }
        }
        if (root.right != null) {
            if (root.right.val <= val) {
                return false;
            }
            if(Objects.equals(step,"L")&& right!=null){
                if(root.right.val>=right){
                    return false;
                }
            }
            if(left!=null){
                if(root.right.val <= left){
                    return false;
                }
            }
            if(right!=null){
                if(root.right.val >= right){
                    return false;
                }
            }
        }
        if (step == null) {
            return process(root.left, "L", null, root.val) && process(root.right, "R", root.val, null);
        } else {
            return process(root.left, step, left, root.val) && process(root.right, step, root.val, right);
        }

    }
}
