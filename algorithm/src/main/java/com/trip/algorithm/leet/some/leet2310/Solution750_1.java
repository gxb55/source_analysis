package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @createTime 2023年10月30日 21:27:00
 */
public class Solution750_1 {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 3, 5, 6};
        int[] arr = {0, 0, 4, 4};
        int i = hIndex(arr);
        System.out.println(i);
    }

    public static int hIndex(int[] citations) {
        int left = 0;
        int res = -1;
        int right = citations.length - 1;
        int len = citations.length;
        if (len == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
            // 当前的值是多少
            int val = citations[mid];
            // 有多个值是大于val的
            int curLen = len - mid;
            if (val >= curLen) {
                res = Math.max(curLen,res);
            }
            if (curLen >= val) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        if (res == -1) {
            if (citations[0] > len) {
                return len;
            }
        }
        return res == -1 ? 0 : res;
    }
}
