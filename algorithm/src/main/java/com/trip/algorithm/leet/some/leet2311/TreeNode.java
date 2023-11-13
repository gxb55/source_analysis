package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * 线段树 区间求和，求最大值
 * @createTime 2023年11月13日 22:07:00
 */
public class TreeNode {
    static int[] arr = {1, 3, 5, 7, 9, 11};
    static TreeNode[] tree = new TreeNode[4 * arr.length];
    public int left;
    public int right;
    public int max;
    public int sum;


    public TreeNode() {
    }

    public static void build(int left, int right, int index) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = left;
        treeNode.right = right;
        if (left == right) {
            treeNode.sum = arr[index];
            tree[index] = treeNode;
            return;
        }
        int mid = (left + right) / 2;
        build(left, mid, 2 * index);
        build(mid + 1, right, 2 * index + 1);
        tree[index].sum = tree[2 * index].sum + tree[2 * index + 1].sum;
    }

    public static void update(int k, int index, int val) {
        if (tree[k].left == tree[k].right && tree[k].left == index) {
            tree[k].sum = val;
            return;
        }
        int mid = (tree[k].left + tree[k].right) / 2;
        if (index < mid) {
            update(mid, index, val);
        } else {
            update(mid + 1, index, val);
        }
        tree[k].sum = tree[2 * k].sum + tree[2 * k + 1].sum;
    }

    public static int query(int k, int l, int r) {
        if (tree[k].left >= l && tree[k].right <= r) {
            return tree[k].sum;
        }
        int mid = (tree[k].left + tree[k].right) / 2;
        int p1 = 0;
        int p2 = 0;
        if (l <= mid) {
            p1 = query(2 * k, l, r);
        }
        if (r > mid) {
            p2 = query(2 * k + 1, l, r);
        }
        return p1 + p2;
    }
}
