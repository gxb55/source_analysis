package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * 线段树 区间求和，求最大值
 * @createTime 2023年11月13日 22:07:00
 */
public class TreeNode {
    public int start, end, max;
    public TreeNode left, right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "start=" + start +
                ", end=" + end +
                ", max=" + max +
                '}';
    }

    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode build = TreeNode.build(arr);
        System.out.println(build);
        build.modify(build,5,20);
        System.out.println(build);
        //print(build);
    }

    private static void print(TreeNode build) {
        if(build==null){
            return;
        }
        System.out.println(build);
        print(build.left);
        print(build.right);
    }

    public static TreeNode build(int[] arr) {
        return build(0, arr.length - 1, arr);
    }

    private static TreeNode build(int left, int right, int[] arr) {
        TreeNode treeNode = new TreeNode(left, right);
        if (left == right) {
            treeNode.max = arr[left];
            return treeNode;
        }
        int mid = (left + right) / 2;
        TreeNode build1 = build(left, mid, arr);
        TreeNode build2 = build(mid + 1, right, arr);
        treeNode.setLeft(build1);
        treeNode.setRight(build2);
        treeNode.max = Math.max(build1.max, build2.max);
        return treeNode;
    }

    public void modify(TreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index > mid) {
            modify(root.right, index, value);
        } else {
            modify(root.left, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }

}
