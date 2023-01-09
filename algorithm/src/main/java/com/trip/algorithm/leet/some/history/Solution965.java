package com.trip.algorithm.leet.some.history;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/5/24  21:22
 * @description 965. 单值二叉树
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 */
public class Solution965 {
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int val = root.val;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val != val) {
                return false;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return true;
    }
}
