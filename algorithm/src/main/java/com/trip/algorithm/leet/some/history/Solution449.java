package com.trip.algorithm.leet.some.history;

import com.trip.algorithm.base.TreeNode;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2022/5/11  9:24
 * @description 449
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * 通过次数22,573提交次数38,982
 */
public class Solution449 {
    public static void main(String[] args) {
        TreeNode pop = new TreeNode(2);
        TreeNode le = new TreeNode(1);
        TreeNode ri = new TreeNode(3);
        pop.left = le;
        pop.right = ri;
        Integer[] arr =
                {41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23};
        TreeNode treeNode = TreeNode.createTreeNode(arr);
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = treeNodes.pop();
                if (pop != null) {
                    stringBuilder.append(pop.val).append("#");
                } else {
                    stringBuilder.append(".").append("#");
                }
                if (pop != null) {
                    treeNodes.add(pop.left);
                    treeNodes.add(pop.right);
                }
            }
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split("#,");
        int index = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        list.add(root);
        while (index < split.length && !list.isEmpty()) {
            String[] chars = split[index].split("#");
            int size = list.size();
            int k = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = list.poll();
                String aChar = chars[k];
                k++;
                if (!aChar.equals(".") ) {
                    TreeNode left = new TreeNode(Integer.valueOf(aChar));
                    poll.left = left;
                    list.add(left);
                }
                aChar = chars[k];
                if (!aChar.equals(".") ) {
                    TreeNode right = new TreeNode(Integer.valueOf(aChar));
                    poll.right = right;
                    list.add(right);
                }
                k++;
            }
            index++;
        }
        return root;
    }
}