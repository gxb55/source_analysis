package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/5/11  22:39
 * @description 400
 * 400. 第 N 位数字
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 通过次数47,716提交次数104,811
 */
public class Solution400 {
    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        int nthDigit = solution400.findNthDigit(10);
        System.out.println(nthDigit);
    }

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        Long num = getNum(n);
        long left = 1;
        long right = num;
        long res=0;
        while (left < right) {
            long middle = left + (right - left) / 2;
            long cur = getLen(middle);
            if (cur > middle) {
                right = middle - 1;
            } else {
                res=left;
                left = middle + 1;
            }
        }
        return getVal(res, n);
    }

    private int getVal(long middle, int n) {
        int length = String.valueOf(middle).length();
        StringBuilder min = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                min.append(1);
            } else {
                min.append("0");
            }
        }
        Long aLong = map.get((long) (length - 1));
        n = (int) (n - aLong);
        long l = (middle - 1 - Long.valueOf(min.toString())) * length;
        n = (int) (n - l);
        String s = String.valueOf(middle);
        return s.charAt(n) - '0';
    }

    private long getLen(long middle) {
        int length = String.valueOf(middle).length();
        StringBuilder min = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                min.append(1);
            } else {
                min.append("0");
            }
        }
        long l = (middle - Long.valueOf(min.toString())) * length;
        return map.get((long) (length - 1)) + l;
    }

    private Map<Long, Long> map = new HashMap<>();

    private Long getNum(int n) {
        Long sum = 0L;
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            max.append(9);
            if (i == 0) {
                min.append(1);
            } else {
                min.append("0");
            }
            long l = Long.valueOf(max.toString()) - Long.valueOf(min.toString()) + 1;
            map.put((long) i + 1, l * i);
            sum = sum + l * i;
            if (sum >= n) {
                break;
            }
        }
        map.put(1L, 9L);
        map.put(0L, 0L);
        return Long.valueOf(max.toString());
    }
}
