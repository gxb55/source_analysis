package com.trip.algorithm.leet.some.everday;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年07月31日 10:10:00
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 * 通过次数17,550提交次数27,019
 */
public class Solution1161 {
    public static void main(String[] args) {
        Solution1161 solution1161 = new Solution1161();
        Integer[] arr = {1, 7, 0, 7, -8, null, null};
        TreeNode treeNode = TreeNode.buildTree(arr);
        // Integer[] arr = {989, null, 10250, 98693, -89388, null, null, null, -32127};
       /*
        int i = solution1161.maxLevelSum(treeNode);
        System.out.println(i);*/

        List<Integer> list = solution1161.preOrder(treeNode);
        System.out.println(list);
    }

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        int temp;
        int res = root.val;
        int indexRes = 1;
        int curIndex = 0;
        while (!treeNodeList.isEmpty()) {
            temp = 0;
            curIndex++;
            int size = treeNodeList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeList.pop();
                if (treeNode.left != null) {
                    treeNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeList.add(treeNode.right);
                }
                temp = temp + treeNode.val;
            }

            if (temp > res) {
                res = temp;
                indexRes = curIndex;
            }
        }
        return indexRes;
    }

    public List<Integer> preOrder(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        int top = 1000;
        int left = 2000;
        int right = 3000;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = treeNode;
        int curStatue = left;
        while (curNode != null) {
            if (curStatue == left) {

                if (curNode.left != null) {
                    stack.add(curNode);
                    curNode = curNode.left;
                    curStatue = left;
                } else {
                    curStatue = right;
                }
            } else if (curStatue == right) {
                if (curNode.right != null) {
                    stack.add(curNode);
                    curNode = curNode.right;
                    curStatue = left;
                } else {
                    curStatue = top;
                }
            } else if (curStatue == top) {
                list.add(curNode.val);
                TreeNode parent = null;
                while (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    if (pop.left == curNode) {
                        curStatue = right;
                    }
                    parent = pop;
                    break;
                }
                curNode = parent;
            }
        }
        return list;
    }
}
