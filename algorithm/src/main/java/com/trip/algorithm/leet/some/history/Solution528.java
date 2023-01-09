package com.trip.algorithm.leet.some.history;

import java.util.Random;

/**
 * @author xbguo
 * @date 2022/4/14  20:22
 * @description 528
 */
public class Solution528 {
    public static void main(String[] args) {
        int[] arr = {3,14,1,7};
        Solution solution = new Solution(arr);
        int i = solution.pickIndex();
        System.out.println(i);
    }
}

class Solution {
    int[] pre;
    int sum = 0;

    public Solution(int[] w) {
        int length = w.length;
        pre = new int[length + 1];
        pre[0] = 0;
        for (int i = 1; i <= w.length; i++) {
            pre[i] = pre[i - 1] + w[i - 1];
        }
        sum = pre[w.length];
    }

    public int pickIndex() {
        int i = new Random().nextInt(sum);
        int left = 0;
        int right = pre.length - 1;
        int may = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (pre[mid] == i) {
                return mid;
            }else if (pre[mid] < i) {
                may = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return may;

    }
}

