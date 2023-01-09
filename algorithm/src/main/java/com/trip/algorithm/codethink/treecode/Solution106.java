package com.trip.algorithm.codethink.treecode;


import com.trip.study.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/11/30 18:25
 * @description Solution106
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *  
 *
 * 示例 1:
 *inorder 是二叉树的中序遍历
 * postorder 是同一棵树的后序遍历
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution106 {
    public static void main(String[] args) {
        Solution106 solution106 = new Solution106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = solution106.buildTree(inorder, postorder);
        TreeNode.show(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return process(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode process(int[] inorder, int[] postorder, int inOrderLeft, int inOrderRight, int postOrderLeft, int postOrderRight) {
        if (inOrderLeft > inOrderRight) {
            return null;
        }
        int i = postorder[postOrderRight];
        int x = inOrderLeft;
        for (; x <= inOrderRight; x++) {
            if (i == inorder[x]) {
                break;
            }
        }
        int curPostOrderLeft = postOrderLeft;
        int t = x - inOrderLeft;
        while (t > 0) {
            postOrderLeft++;
            t--;
        }
        TreeNode treeNode = new TreeNode(i);
        treeNode.left = process(inorder, postorder, inOrderLeft, x - 1, curPostOrderLeft, postOrderLeft-1);
        treeNode.right = process(inorder, postorder, x + 1, inOrderRight, postOrderLeft , postOrderRight - 1);

        return treeNode;
    }

    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

}
