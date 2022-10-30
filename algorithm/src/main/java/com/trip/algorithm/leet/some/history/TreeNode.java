package com.trip.algorithm.leet.some.history;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Administrator
 */
@Getter
@Setter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
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

    public static void print(TreeNode root) {
        System.out.println("The binary tree is:");
        if (root == null) {
            System.out.println("Empty binary tree!");
        }
        int height = getHeight(root);
        int arrHeight = height * 2 - 1;
        int arrWidth = (2 << (height - 2)) * 3 + 1;
        String[][] r = new String[arrHeight][arrWidth];
        for (int i = 0; i < arrHeight; i++) {
            for (int j = 0; j < arrWidth; j++) {
                r[i][j] = " ";
            }
        }
        writeToArray(height, root, r, 0, arrWidth / 2);
        for (String[] line : r) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                strBuilder.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(strBuilder);
        }
    }

    private static int getHeight(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getHeight(root.left), getHeight(root.right)));
    }

    private static void writeToArray(int height, TreeNode node, String[][] r, int i, int j) {
        if (node == null) {
            return;
        }
        r[i][j] = String.valueOf(node.val);
        int curLevel = (i + 1) >> 1;
        if (curLevel == height) {
            return;
        }
        int gap = height - curLevel - 1;
        if (node.left != null) {
            r[i + 1][j - gap] = "/";
            writeToArray(height, node.left, r, i + 2, j - gap * 2);
        }
        if (node.right != null) {
            r[i + 1][j + gap] = "\\";
            writeToArray(height, node.right, r, i + 2, j + gap * 2);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node16 = new TreeNode(16);

        node14.left = node15;
        node14.right = node16;
        node10.right = node14;
        node8.left = node10;
        node12.right = node13;
        node9.left = node12;
        node7.left = node8;
        node7.right = node9;
        node3.right = node7;
        node5.left = node6;
        node4.right = node5;
        node2.left = node4;
        root.left = node2;
        root.right = node3;
        TreeNode.print(root);
        preOrder(root);
        System.out.println("*********************************");
        preOrder1(root);
        System.out.println("=================================");

        middleOrder(root);
        System.out.println("*********************************");
        middleOrder1(root);
        System.out.println("=================================");
    }

    private static void middleOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.peek();
            while (pop.left != null) {
                stack.add(pop.left);
                pop=pop.left;
            }

            if (pop.right != null) {
                stack.add(pop.right);
            }
        }

    }

    private static void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左 根 右
        middleOrder(root.left);
        System.out.println(root.val);
        middleOrder(root.right);
    }

    /**
     * 先序递归调用
     *
     * @param root
     */
    private static void preOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


}

