package com.trip.algorithm.leet.some.leet08;

import com.trip.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/8/30  17:05
 * @description Solution662
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 * 通过次数75,741提交次数173,755
 *
 * 1073741823
 * 预期结果：
 * 2147483645
 */
public class Solution662 {
    public static void main(String[] args) {
        //   Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        // Integer[] arr = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        //Integer[] arr = {0, 0, 0, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null, null, 0, 0, null};
        Integer[] arr = {1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null};
        //Integer[] arr = {1,3,2,5};
        TreeNode treeNode = TreeNode.buildTree(arr);
        //  TreeNode.show(treeNode);
        Solution662 solution662 = new Solution662();
        int i = solution662.widthOfBinaryTree(treeNode);
        System.out.println(i);
    }

    public int widthOfBinaryTree(TreeNode root) {
        long max = 0;
        Queue<Map> list = new LinkedList<>();
        Map map = new HashMap();
        map.put("node", root);
        map.put("val", 1L);
        list.add(map);
        while (!list.isEmpty()) {
            int size = list.size();
            long left = -1;
            long right = -1;
            for (int i = 0; i < size; i++) {
                Map poll = list.poll();
                if (poll != null) {
                    TreeNode treeNode = (TreeNode) poll.get("node");
                    Long val = (Long) poll.get("val");
                    if (left == -1) {
                        left = val;
                    }
                    right = Math.max(right, val);
                    if (treeNode.left != null) {
                        Map map1 = new HashMap();
                        map1.put("node", treeNode.left);
                        map1.put("val", (val - 1) * 2 + 1);
                        list.add(map1);
                    }
                    if (treeNode.right != null) {
                        Map map1 = new HashMap();
                        map1.put("node", treeNode.right);
                        map1.put("val", (val - 1) * 2 + 2);
                        list.add(map1);
                    }
                }
            }
            max = Math.max(max, (right - left + 1));
        }
        return (int) max;
    }

    private int getMax(List<TreeNode> list) {
        int left = -1;
        int right = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                if (left == -1) {
                    left = i;
                }
                right = Math.max(right, i);
            }
        }
        return right - left + 1;
    }
}
