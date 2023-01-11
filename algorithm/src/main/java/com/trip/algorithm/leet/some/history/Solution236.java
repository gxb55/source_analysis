package com.trip.algorithm.leet.some.history;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/4/24  16:23
 * @description 236
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * 通过次数364,732提交次数529,170
 */
public class Solution236 {
    public static void main(String[] args) {
        Solution236 solution236 = new Solution236();

        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root8 = new TreeNode(8);
        TreeNode root0 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);

        root.left = root2;
        root.right = root8;
        root8.left = root7;
        root8.right = root9;
        root2.left = root0;
        root2.right = root4;

        root4.left = root3;
        root4.right = root5;

        TreeNode treeNode = solution236.lowestCommonAncestor(root, root0, root9);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        getParent(root, p, list);
        List<TreeNode> list1 = new ArrayList<>();
        list1.add(root);
        getParent(root, q, list1);
        for (int i = list.size()-1; i >=0; i--) {
            TreeNode treeNode = list.get(i);
            if(list1.contains(treeNode)){
                return treeNode;
            }
        }
        return null;

    }

    private boolean getParent(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root.val == p.val) {
            return true;
        }
        if (root.left != null) {
            list.add(root.left);
            boolean parent = getParent(root.left, p, list);
            if (parent) {
                return true;
            }
            list.remove(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
            boolean parent = getParent(root.right, p, list);
            if (parent) {
                return true;
            }
            list.remove(root.right);
        }
        return false;
    }
}
