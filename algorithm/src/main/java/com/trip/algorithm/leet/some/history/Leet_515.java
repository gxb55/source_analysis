package com.trip.algorithm.leet.some.history;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年04月23日 17:20:00
 * <p>
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * 通过次数59,298提交次数90,508
 */
public class Leet_515 {
    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);

        List<Integer> result = new ArrayList<>();
        while (!list.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>(list);
            Integer max = null;
            list.clear();
            for (TreeNode treeNode : temp) {
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
                if (max == null) {
                    max = treeNode.val;
                } else {
                    max = Math.max(treeNode.val, max);
                }
            }
            result.add(max);
        }
        return result;


    }
}
