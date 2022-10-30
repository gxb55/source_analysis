package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年06月05日 22:07:00
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 通过次数292,315提交次数449,717
 */
public class Solution279 {
    public static void main(String[] args) {

    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int cur = i * i;
            if (cur > n) {
                break;
            }
            list.add(cur);
        }
        int[] arr = new int[list.size()];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = list.get(i);
        }
        int[][] dp = new int[arr.length][n+1];

        return 0;
    }
}
