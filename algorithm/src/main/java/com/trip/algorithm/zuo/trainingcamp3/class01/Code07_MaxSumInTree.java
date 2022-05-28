package com.trip.algorithm.zuo.trainingcamp3.class01;

import com.trip.algorithm.zuo.trainingcamp3.Node;

/**
 * 给定一个二叉树的头节点head，路径的规定有以下三种不同的规定：
 * <p>
 * 1）路径必须是头节点出发，到叶节点为止，返回最大路径和
 * 遍历整棵树，在叶子节点的时候判断结果是否是最大即可
 * <p>
 * 2）路径可以从任何节点出发，但必须往下走到达任何节点，返回最大路径和
 * 树中任意向下的一段距离
 * <p>
 * 3）路径可以从任何节点出发，到任何节点，返回最大路径和
 */
public class Code07_MaxSumInTree {
    public static int maxSum = Integer.MIN_VALUE;

    /**
     * 问题：路径必须是头节点出发，到叶节点为止，返回最大路径和 ？
     * 思路就是从头开始遍历整颗树，然后求出来最大的
     *
     * @param head
     * @return
     */
    public static int maxPath(Node head) {
        p(head, 0);
        return maxSum;
    }

    /**
     * @param x   当前节点
     * @param pre 当前节点之前的数相加的和
     */
    public static void p(Node x, int pre) {
        if (x.left == null && x.right == null) {
            maxSum = Math.max(pre + x.value, maxSum);
        }
        if (x.left != null) {
            p(x.left, pre + x.value);
        }
        if (x.right != null) {
            p(x.right, pre + x.value);
        }
    }

    /**
     * 问题：路径必须是头节点出发，到叶节点为止，返回最大路径和 ？
     *
     * @param head
     * @return
     */
    public static int maxDis(Node head) {
        if (head == null) {
            return 0;
        }
        return process2(head);
    }

    /**
     * 没个结点计算出左右的两颗树中的最大值返回，一次类推
     *
     * @param x 头节点
     * @return
     */
    public static int process2(Node x) {
        // 叶子节点
        if (x.left == null && x.right == null) {
            return x.value;
        }
        // 向左算个最大值，给出来
        int leftMax = Integer.MIN_VALUE;
        if (x.left != null) {
            leftMax = process2(x.left);
        }
        // 向右算个最大值给出来
        int rightMax = Integer.MIN_VALUE;
        if (x.right != null) {
            rightMax = process2(x.right);
        }
        return Math.max(leftMax, rightMax) + x.value;
    }

    public static class Info {
        /**
         * 整颗树最大的值
         */
        public int allTreeMaxSum;
        /**
         * 从当前节点开始最大的值
         */
        public int fromHeadMaxSum;

        public Info(int allTreeMaxSum, int fromHeadMaxSum) {
            this.allTreeMaxSum = allTreeMaxSum;
            this.fromHeadMaxSum = fromHeadMaxSum;
        }
    }

    public static int maxSum2(Node head) {
        if (head == null) {
            return 0;
        }
        return f(head).allTreeMaxSum;
    }

    /**
     * 1.跟当前节点有关 1.1 当前节点；1.2当前节点+左子树 1.3 当前节点+右子树
     * 2.跟当前节点无关 2.1 左子树 2.2右子树
     * 分三种情况
     *
     * @param head
     * @return
     */
    public static Info f(Node head) {
        if (head == null) {
            return null;
        }
        //1.1
        int p1 = Integer.MIN_VALUE;
        //1.2
        int p2 = Integer.MIN_VALUE;
        //1.3
        int p3 = Integer.MIN_VALUE;
        //2.1
        int p4 = Integer.MIN_VALUE;
        //2.2
        int p5 = Integer.MIN_VALUE;
        Info leftInfo = f(head.left);
        Info rightInfo = f(head.right);
        p1 = head.value;
        if (leftInfo != null) {
            p2 = p1 + leftInfo.fromHeadMaxSum;
            p4 = f(head.left).allTreeMaxSum;
        }
        if (rightInfo != null) {
            p3 = p1 + rightInfo.fromHeadMaxSum;
            p5 = rightInfo.allTreeMaxSum;
        }
        int fromHeadMaxSum = Math.max(Math.max(p1, p2), p3);
        int allTreeMaxSum = Math.max(Math.max(Math.max(p1, p2), p3), Math.max(p4, p5));
        return new Info(allTreeMaxSum, fromHeadMaxSum);
    }


    public static int maxSum3(Node head) {
        if (head == null) {
            return 0;
        }
        return f3(head).allTreeMaxSum;
    }

    /**
     * 1.跟当前节点无关 1.1 左子树 ；1.2右子树
     * 2.跟当前节点有关 2.1 x自己 2.2 x往左走 2.3 x往右走 2.4 x既往左也往右
     * 分⑤种情况
     *
     * @param head
     * @return
     */
    public static Info f3(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = f3(head.left);
        Info rightInfo = f3(head.right);
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p1 = leftInfo.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p2 = rightInfo.allTreeMaxSum;
        }
        int p3 = head.value;

        int p4 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p4 = leftInfo.fromHeadMaxSum + p3;
        }
        int p5 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p5 = rightInfo.fromHeadMaxSum + p3;
        }
        int p6 = Integer.MIN_VALUE;
        if (rightInfo != null && leftInfo != null) {
            p6 = rightInfo.fromHeadMaxSum + p3 + leftInfo.fromHeadMaxSum;
        }
        int fromHeadMaxSum = Math.max(Math.max(p1, p2), p3);
        int allTreeMaxSum = Math.max(Math.max(Math.max(p1, p2), p3), Math.max(p4, Math.max(p5, p6)));
        return new Info(allTreeMaxSum, fromHeadMaxSum);
    }


}
