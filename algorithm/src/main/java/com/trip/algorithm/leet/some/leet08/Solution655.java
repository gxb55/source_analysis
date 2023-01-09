package com.trip.algorithm.leet.some.leet08;

import com.trip.study.algorithm.tree.TreeNode;
import jodd.util.StringUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xbguo
 * @date 2022/8/22  10:36
 * @description Solution655
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 * 通过次数17,290提交次数26,275
 */
public class Solution655 {
    public static void main(String[] args) {
        Solution655 solution655 = new Solution655();
        // Integer[] arr = {1, 2};
        Integer[] arr = {1, 2, 3, null, 4};
        TreeNode treeNode = TreeNode.buildTree(arr);

        List<List<String>> list = solution655.printTree(treeNode);
        for (List<String> list1 : list) {
            for (int i = 0; i < list1.size(); i++) {
                String s = list1.get(i);
                if (StringUtil.isEmpty(s)) {
                    System.out.print("-" + " ");
                } else {
                    System.out.print(s + " ");
                }

            }
            System.out.println();
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            index++;
        }
        int height = index;

        List<List<TreeNode>> list = new ArrayList<>();
        int y = (int) (Math.pow(2, height)) - 1;
        for (int i = 0; i < height; i++) {
            List<TreeNode> collect = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                collect.add(null);
            }
            list.add(collect);
        }
        List<TreeNode> list1 = list.get(0);
        list1.set((list1.size() - 1) / 2, root);
        for (int i = 0; i < list.size(); i++) {
            List<TreeNode> list2 = list.get(i);
            List<TreeNode> list3 = null;
            if ((i + 1) < list.size()) {
                list3 = list.get(i + 1);
            }
            for (int j = 0; j < list2.size(); j++) {
                TreeNode treeNode = list2.get(j);
                int r = i;
                int c = j;
                // 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
                if (treeNode != null && list3 != null) {
                    if (treeNode.left != null) {
                        int in = c - ((2 * (height - 1)) - r - 1);
                        list3.set(in, treeNode.left);
                    }
                    if (treeNode.right != null) {
                        list3.set(c + ((2 * (height - 1)) - r - 1), treeNode.right);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<TreeNode> list2 = list.get(i);
            List<String> list3 = new ArrayList<>();
            for (int j = 0; j < list2.size(); j++) {
                if (list2.get(j) == null) {
                    list3.add("");
                } else {
                    list3.add(String.valueOf(list2.get(j).v));
                }
            }
            res.add(list3);
        }
        return res;
    }

    /**
     * 解题方案
     * 思路：
     * 标签：动态规划
     * 首先初始化长度为 n+1 的数组 dp，每个位置都为 0
     * 如果 n 为 0，则结果为 0
     * 对数组进行遍历，下标为 i，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
     * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
     * 时间复杂度：O(n*sqrt(n))O(n∗sqrt(n))，sqrt 为平方根
     *
     * 作者：guanpengchn
     * 链接：https://leetcode.cn/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
        public int numSquares(int n) {
            int[] dp = new int[n + 1]; // 默认初始化值都为0
            for (int i = 1; i <= n; i++) {
                dp[i] = i; // 最坏的情况就是每次+1
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
                }
            }
            return dp[n];
        }


}
