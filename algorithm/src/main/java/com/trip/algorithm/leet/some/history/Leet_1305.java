package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年05月01日 10:32:00
 * <p>
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 * 通过次数24,013提交次数31,267
 */
public class Leet_1305 {
    public static void main(String[] args) {
        Leet_1305 leet_1305 = new Leet_1305();
        TreeNode roo1 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        roo1.left = node1;
        roo1.right = node4;

        TreeNode roo2 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        roo2.left = node0;
        roo2.right = node3;
        List<Integer> allElements = leet_1305.getAllElements(roo1, roo2);
        System.out.println(allElements);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if(root1==null){
            List<Integer> list1 = new ArrayList<>();
            process(root2, list1);
            return list1;
        }
        if(root2==null){
            List<Integer> list1 = new ArrayList<>();
            process(root1, list1);
            return list1;
        }
        List<Integer> list = new ArrayList<>();
        process(root1, list);
        List<Integer> list1 = new ArrayList<>();
        process(root2, list1);
        int i = 0;
        int j = 0;
        List<Integer> re = new ArrayList<>();
        while (i < list.size() && j < list1.size()) {
            Integer integer = list.get(i);
            Integer integer1 = list1.get(j);
            if (integer < integer1) {
                i++;
                re.add(integer);
            } else {
                j++;
                re.add(integer1);
            }
        }
        if (i < list.size()) {
            for (int k = i; k < list.size(); k++) {
                Integer integer = list.get(k);
                re.add(integer);
            }
        }
        if (j < list1.size()) {
            for (int k = j; k < list1.size(); k++) {
                Integer integer = list1.get(k);
                re.add(integer);
            }
        }
        return re;
    }

    private void process(TreeNode root1, List<Integer> list) {
        if (root1 == null) {
            return;
        }
        process(root1.left, list);
        list.add(root1.val);
        process(root1.right, list);
    }
}
