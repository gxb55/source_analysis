package com.trip.algorithm.leet.some.history;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/6/22  13:54
 * @description 513. 找树左下角的值
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 * 通过次数110,451提交次数149,162
 */
public class Solution513 {
    public static void main(String[] args) {
        Solution513 solution513 = new Solution513();
       // Integer[] arr = {2, 1, 3};
        Integer[] arr = {1,2,3,4,null,5,6,null,null,7};
        TreeNode treeNode = TreeNode.createTreeNode(arr);
        int bottomLeftValue = solution513.findBottomLeftValue(treeNode);
        System.out.println(bottomLeftValue);
    }

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int val = -1;
        while (!list.isEmpty()) {
            val = getVal(list);
            LinkedList<TreeNode> temp = new LinkedList<>();
            while (!list.isEmpty()) {
                TreeNode pop = list.pop();
                if (pop != null) {
                    if (pop.left != null || pop.right != null) {
                        temp.add(pop.left);
                        temp.add(pop.right);
                    }
                }
            }
            list = temp;
        }
        return val;
    }

    private int getVal(List<TreeNode> list) {
        TreeNode treeNode = null;
        for (int i = 0; i < list.size(); i++) {
            if ((i / 2) == 0) {
                treeNode = list.get(i);
                if (treeNode != null) {
                    break;
                }
            }
        }
        return treeNode.val;
    }
}
