package com.trip.algorithm.leet.data;

/**
 * @author xbguo
 * @createTime 2022年04月04日 13:50:00
 * 树桩数组
 */
public class NumArray {
    int[] tree;

    /**
     * 输入一个下标，返回该下标二进制最后一个1
     * 即
     * 0000 1010
     * 1010
     * @param x
     * @return
     */
    int lowbit(int x) {
        return x & -x;
    }

    /**
     * 查询到当前下标的数组和
     * @param x 下标
     * @return
     */
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    /**
     * 构建树状数组
     * @param x 下标
     * @param u 当前下标的值
     */
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += u;
        }
    }

    int[] nums;
    int n;

    public NumArray(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,7,12,6,5,1,3,2};
        NumArray numArray = new NumArray(arr);

    }
}

