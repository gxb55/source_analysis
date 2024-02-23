package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/2/22 17:06
 */
public class Solution889 {
    public static void main(String[] args) {
        Solution889 solution889 = new Solution889();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7}, postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = solution889.constructFromPrePost(preorder, postorder);
        TreeNode.print(treeNode);
    }

    int[] preorder;
    int[] postorder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();

        this.preorder = preorder;
        List<Integer> collect = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        this.postorder = new int[postorder.length];
        int index = 0;
        for (int i = collect.size() - 1; i >= 0; i--) {
            this.postorder[index++] = collect.get(i);
        }
        for (int i = 0; i < this.postorder.length; i++) {
            postMap.put(this.postorder[i], i);
        }
        // 根左右
        // 左右根 根右左
        return process(postMap, 0, postorder.length - 1, 0, postorder.length - 1);

    }

    private TreeNode process(Map<Integer, Integer> postMap, int l, int r, int l1, int r1) {
        if (l == r) {
            return new TreeNode(preorder[l]);
        }
        if (l > r) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[l]);
        if ((l + 1) < preorder.length) {
            int i = preorder[l + 1];
            Integer integer = postMap.get(i);
            // 根左右
            // 根右左
            int len = r1-integer ;

            treeNode.left = process(postMap, l + 1, l + 1 + len, r1 - len, r1);
            treeNode.right = process(postMap, l + 1 + len+1 , r, l1, r1 - len - 1);
        }
        return treeNode;
    }


}
