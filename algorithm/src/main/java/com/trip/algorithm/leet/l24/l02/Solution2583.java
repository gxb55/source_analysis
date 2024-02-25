package com.trip.algorithm.leet.l24.l02;

import com.trip.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2583 {
    public static void main(String[] args) {
        Integer[] arr={5,8,9,2,1,3,7};
        int k=4;
        Solution2583 solution2583 =new Solution2583();
        long l = solution2583.kthLargestLevelSum(TreeNode.buildTree(arr), k);
        System.out.println(l);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            long sum=0;
            int size = linkedList.size();
            while (size>0){
                size--;
                TreeNode treeNode = linkedList.pollFirst();
                sum=sum+treeNode.val;
                if(treeNode.left!=null){
                    linkedList.addLast(treeNode.left);
                }
                if(treeNode.right!=null){
                    linkedList.addLast(treeNode.right);
                }
            }
            list.add(sum);
        }
        list.sort((o1, o2) ->  (o2-o1)>=0?1:-1);
        if(k>list.size()){
            return -1;
        }
        return list.get(k-1);
    }
}
