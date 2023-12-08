package com.trip.algorithm.leet.some.leet2312;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/12/4 18:24
 */
public class Solution1038 {
    public static void main(String[] args) {
        //Integer[] arr = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
       // Integer[] arr = {0,null,1};
        Integer[] arr = {3,2,4,1};
        Solution1038 solution1038 = new Solution1038();
        TreeNode treeNode = solution1038.bstToGst(TreeNode.buildTree(arr));
        TreeNode.print(treeNode);
    }

    /**
     * 提醒一下， 二叉搜索树 满足下列约束条件：
     * <p>
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     */
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getSum(root, list);
        int sum = 0;
        for (int t : list) {
            sum += t;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer i1 = list.get(i);
            map.put(i1, sum);
            sum = sum - i1;
        }
        process(root,list,map);
        return root;
    }

    private void getSum(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getSum(root.left, list);
        list.add(root.val);
        getSum(root.right, list);
    }

    private void process(TreeNode root, List<Integer> list, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int val = root.val;
        int i = list.indexOf(val);
        Integer i1 = map.get(val);
        root.val=i1;
        process(root.left,list,map);
        process(root.right,list,map);

    }


}
