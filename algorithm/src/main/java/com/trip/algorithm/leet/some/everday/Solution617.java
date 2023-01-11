package com.trip.algorithm.leet.some.everday;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @createTime 2022年08月06日 16:47:00
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 */
public class Solution617 {
    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();
       /* Integer[] root1 = {1, 3, 2, 5};
        Integer[] root2 = {2, 1, 3, null, 4, null, 7}; */

      /*  Integer[] root1 = {1 };
        Integer[] root2 = {1,2};*/

        Integer[] root1 = {-4, null, 5, 2, 9, 0, 3, 7, null, null, 1, null, null, 6, 8};
        Integer[] root2 = {9, 7, null, 6, 7501};

        TreeNode treeNode = solution617.mergeTrees(TreeNode.buildTree(root1), TreeNode.buildTree(root2));
        TreeNode.print(treeNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        boolean flag = true;
        process(root1, root2, flag);
        return root1;
    }

    private void process(TreeNode root1, TreeNode root2, boolean flag) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (root1 != null && root2 == null) {
            return;
        }
        if (flag) {
            root1.val = root1.val + root2.val;
        }
        boolean leftFlag = true;
        boolean rightFlag = true;
        if (root1.left == null && root2.left != null) {
            root1.left = new TreeNode(root2.left.val);
            leftFlag = false;
        }
        if (root1.right == null && root2.right != null) {
            root1.right = new TreeNode(root2.right.val);
            rightFlag = false;
        }

        process(root1.left, root2.left, leftFlag);
        process(root1.right, root2.right, rightFlag);
    }
}
