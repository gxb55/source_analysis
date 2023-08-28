package com.trip.algorithm.leet.some.Leet2308;

import com.trip.algorithm.base.TreeNode;

/**
 * @author xbguo
 * @date 2023/8/28 19:07
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 */
public class Solution437 {
    public static void main(String[] args) {
       /* Integer[] root = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int targetSum = 8; */

      /*  Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;*/

        Integer[] root = {1,null,2,null,3,null,4,null,5};
        int targetSum = 3;
        TreeNode treeNode = TreeNode.buildTree(root);
        TreeNode.print(treeNode);
        Solution437 solution437 = new Solution437();
        int i = solution437.pathSum(treeNode, targetSum);
        System.out.println(i);
    }

    public int pathSum(TreeNode root, int targetSum) {
        res = targetSum;
        process(root, 0);
        return count;
    }

    int count = 0;
    int res = 0;

    private void process(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (cur+root.val == res) {
            count++;
        }
        process(root.left, cur + root.val);
        process(root.left, 0);
        process(root.right, cur + root.val);
        process(root.right, 0);

    }


}
