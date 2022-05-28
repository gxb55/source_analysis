package com.trip.algorithm.leet.some;

/**
 * @author xbguo
 * @createTime 2022年04月04日 09:47:00
 */
public class Leet_307 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        NumArray numArray = new NumArray(arr);
        numArray.update(0, 10);
        int i = numArray.sumRange(1, 2);
        System.out.println(i);

    }
}

class NumArray {

    int[] arr = null;
    int[] tree = null;
    int len = 0;

    public int lowBit(int x) {
        return x & (~x + 1);
    }

    /**
     * @param x   下标
     * @param val 下标对应的值
     */
    public void add(int x, int val) {
        for (int i = x; i <= len ; i = i + lowBit(i)) {
            tree[i] = tree[i] + val;
        }
    }

    /**
     * 0->x 的和
     *
     * @param x
     * @return
     */
    public int query(int x) {
        int sum = 0;
        for (int i = x; i > 0; i = i - lowBit(i)) {
            sum = sum + tree[i];
        }
        return sum;
    }

    public NumArray(int[] nums) {
        arr = nums;
        len = nums.length;
        tree = new int[len + 1];
        for (int i = 0; i < len; i++) {
            add(i + 1, arr[i]);
        }
    }

    public void update(int index, int val) {
        int oldVal = arr[index];
        add(index + 1, val - oldVal);
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }


}