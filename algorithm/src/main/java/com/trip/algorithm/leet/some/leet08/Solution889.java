package com.trip.algorithm.leet.some.leet08;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/16  14:40
 * @description 889. 根据前序和后序遍历构造二叉树
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 先 根左右
 * 后 左右跟
 */
public class Solution889 {
    public static void main(String[] args) {
        Solution889 solution889 = new Solution889();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

      /*  int[] preorder = {2, 1};
        int[] postorder = {1, 2};*/
        TreeNode treeNode = solution889.constructFromPrePost1(preorder, postorder);
        TreeNode.show(treeNode);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode treeNode = new TreeNode(-1);
        process(preorder, postorder, 0, preorder.length, 0, postorder.length, treeNode, "");
        return treeNode.left;
    }

    private void process(int[] preorder, int[] postorder, int preBegin, int preEnd, int postBegin, int postEnd, TreeNode treeNode, String type) {
        if (preBegin > preEnd) {
            return;
        }
        if ((preBegin + 1) == preEnd || preBegin == preEnd) {
            if (type.equals("")) {
                TreeNode le = new TreeNode(preorder[preBegin]);
                treeNode.left = le;
            } else if (type.equals("L")) {
                treeNode.left = new TreeNode(preorder[preBegin]);
            } else if (type.equals("R")) {
                treeNode.right = new TreeNode(preorder[preBegin]);
            }
            return;
        }

        int[] arr = getIndex(preorder, postorder, preBegin + 1, preEnd, postBegin, postEnd - 1);
        if (type.equals("")) {
            TreeNode le = new TreeNode(preorder[preBegin]);
            treeNode.left = le;
            process(preorder, postorder, preBegin + 1, arr[0], postBegin, arr[1], le, "L");
            process(preorder, postorder, arr[0], preEnd, arr[1], postEnd - 1, le, "R");
        } else if (type.equals("L")) {
            treeNode.left = new TreeNode(preorder[preBegin]);
            process(preorder, postorder, preBegin + 1, arr[0], postBegin, arr[1], treeNode.left, "L");
            process(preorder, postorder, arr[0], preEnd, arr[1], postEnd - 1, treeNode.left, "R");
        } else if (type.equals("R")) {
            treeNode.right = new TreeNode(preorder[preBegin]);
            process(preorder, postorder, preBegin + 1, arr[0], postBegin, arr[1], treeNode.right, "L");
            process(preorder, postorder, arr[0], preEnd, arr[1], postEnd - 1, treeNode.right, "R");
        }

    }

    private int[] getIndex(int[] preorder, int[] postorder, int preBegin, int preEnd, int postBegin, int postEnd) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int i = preBegin, j = postBegin;
        while (true) {
            for (; i < preEnd; i++) {
                list1.add(preorder[i]);
                i++;
                break;
            }
            for (; j < postEnd; i++) {
                list2.add(postorder[j]);
                j++;
                break;
            }
            boolean flag = list1.stream().allMatch(x -> list2.contains(x));
            if (flag) {
                break;
            }
        }
        return new int[]{i, j};
    }


    Map<Integer,Integer> map = new HashMap();
    public TreeNode constructFromPrePost1(int[] preorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(postStart > postEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        //获取根节点值
        int rootValue = preorder[preStart];

        //确定左子树
        int leftValue = preorder[preStart+1];
        int leftIndex = map.get(leftValue);

        //左子树节点在后序中的索引位置
        int leftSize = leftIndex-postStart+1;

        //根节点
        TreeNode root = new TreeNode(rootValue);
        /**
         preStart+1: 前序中第一个是根节点，所以+1
         preStart+leftSize： 确定左树的结束位置
         */
        root.left = build(preorder,preStart+1,preStart+leftSize,postorder,postStart,leftIndex);
        root.right = build(preorder,preStart+leftSize+1,preEnd,postorder,leftIndex+1,postEnd-1);
        return root;
    }

}
