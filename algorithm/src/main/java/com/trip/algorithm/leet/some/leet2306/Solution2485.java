package com.trip.algorithm.leet.some.leet2306;

/**
 * @author xbguo
 * @date 2023/6/26 09:11
 */
public class Solution2485 {
    public static void main(String[] args) {
        int n = 4;
        Solution2485 solution2485 = new Solution2485();
        int i = solution2485.pivotInteger(n);
        System.out.println(i);
    }

    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x1 = (1 + mid) * (mid - 1 + 1) / 2;
            int x2 = (n + mid) * (n - mid + 1) / 2;
            if (x2 == x1) {
                return mid;
            }
            if (x1 > x2) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return -1;
    }

}
