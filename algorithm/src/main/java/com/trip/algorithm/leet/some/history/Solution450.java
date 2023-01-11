package com.trip.algorithm.leet.some.history;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年06月03日 13:57:00
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 */
public class Solution450 {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur.val != key) {
            pre = cur;
            if (key > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (cur.left == null && cur.right == null && pre != null) {
            if (pre.left == cur) {
                pre.left = null;
            } else if (pre.right == cur) {
                pre.right = null;
            }
        }

        if (cur.left != null && cur.right != null && pre != null) {
            if (pre.left == cur) {
                pre.left = null;
            } else if (pre.right == cur) {
                pre.right = null;
            }
        }

        return null;
    }
}
