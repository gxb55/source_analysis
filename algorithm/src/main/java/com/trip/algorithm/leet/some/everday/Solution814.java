package com.trip.algorithm.leet.some.everday;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2022年07月24日 09:14:00
 * 814. 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 200] 内
 * Node.val 为 0 或 1
 * 通过次数53,166提交次数73,247
 */
public class Solution814 {
    public static void main(String[] args) {
        Solution814 solution814 = new Solution814();
       // Integer[] arr = {1, null, 0, 0, 1};
      //  Integer[] arr = {1,0,1,0,0,0,1};
        Integer[] arr = {1,null,0,0,1};
        TreeNode treeNode = TreeNode.buildTree(arr);

        solution814.pruneTree(treeNode);
        System.out.println(treeNode);
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean process = process(root);
        if(process){
            return null;
        }
        return null;
    }

    private boolean process(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean p1 = process(root.left);
        boolean p2 = process(root.right);
        if (p1) {
            root.left=null;
        }
        if (p2) {
            root.right=null;
        }
        return p1 && p2 && root.val == 0;
    }
   static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static TreeNode buildTree(Integer[] A) {
            if (A == null || A.length == 0) {
                return null;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            for (int i = 0; i < A.length; i++) {
                TreeNode node = A[i] != null ? new TreeNode(A[i]) : null;
                queue.addLast(node);
            }
            TreeNode root = queue.pollFirst();
            //存放父亲节点（上一层节点）
            LinkedList<TreeNode> fatherNode = new LinkedList<>();
            // 存放当前节点
            LinkedList<TreeNode> sonNode = new LinkedList<>();
            fatherNode.addLast(root);
            // 层次遍历 记录不是空节点的个数 用来决定下一层应该有多少个节点
            int noEmpty = 1;
            while (!queue.isEmpty()) {
                //确定下一层节点个数
                int size = 2 * noEmpty;
                // 最后一层叶子可能不满，所以记录最后一层多少节点
                if (queue.size() < size) {
                    size = queue.size();
                }
                noEmpty = 0;
                while (size != 0) {
                    //计算不为空节点的个数
                    TreeNode first = queue.pollFirst();
                    if (first != null) {
                        noEmpty++;
                    }
                    sonNode.addLast(first);
                    size--;
                }
                int i = 0;
                int j = 0;
                for (i = 0; i < fatherNode.size(); i++) {
                    TreeNode node = fatherNode.get(i);
                    //如果当前节点是空的，则不需要给他分配左右子树节点
                    if (node == null) {
                        continue;
                    }
                    int left = 2 * j;
                    int right = 2 * j + 1;
                    j++;
                    // 分配左右子树节点 另外对边界进行一个验证
                    if (left < sonNode.size()) {
                        node.left = sonNode.get(left);
                    }
                    if (right < sonNode.size()) {
                        node.right = sonNode.get(right);
                    }
                }
                //给上一层节点都绑定了左右子树 所以层数往下移动 当前节点层数充当下一次的父节点层数
                fatherNode.clear();
                fatherNode.addAll(sonNode);
                sonNode.clear();
            }
            return root;
        }

    }
}
