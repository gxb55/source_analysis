package com.trip.algorithm.leet.some.leet08;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2022/8/30  14:52
 * @description Solution998
 * 998. 最大二叉树 II
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,2,4,null,1], val = 3
 * 输出：[5,2,4,null,1,null,3]
 * 解释：a = [2,1,5,4], b = [2,1,5,4,3]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,2,3,null,1], val = 4
 * 输出：[5,2,4,null,1,3]
 * 解释：a = [2,1,5,3], b = [2,1,5,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 100] 内
 * 1 <= Node.val <= 100
 * 树中的所有值 互不相同
 * 1 <= val <= 100
 * <p>
 * <p>
 * 通过次数18,065提交次数26,897
 */
public class Solution998 {
    public static void main(String[] args) {
        Solution998 solution998 = new Solution998();
       /* Integer[] root = {4, 1, 3, null, null, 2};
        int val = 5;*/
      /*  Integer[] root = {5, 2, 4, null, 1};
        int val = 3; */

        Integer[] root = {5, 2, 3, null, 1};
        int val = 4;
        TreeNode treeNode1 = TreeNode.buildTree(root);
        TreeNode treeNode = solution998.insertIntoMaxTree(treeNode1, val);
        TreeNode.show(treeNode);
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.getVal()) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        addNode(root, root.right, val);
        return root;
    }

    private void addNode(TreeNode parent, TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            parent.right = node;
            return;
        } else if (val > root.getVal()) {
            TreeNode node = new TreeNode(val);
            TreeNode right = parent.right;
            parent.right = node;
            node.left = right;
            return;
        }
        addNode(root, root.right, val);
    }
}
