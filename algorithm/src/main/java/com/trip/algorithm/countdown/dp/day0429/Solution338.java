package com.trip.algorithm.countdown.dp.day0429;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2023年04月29日 09:02:00
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 * 勉强动态规划，不算经典的
 */
public class Solution338 {
    public static void main(String[] args) {
        int n = 10;
        int[] ints = countBits(n);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (res.length == 1) {
            res[0] = 0;
        } else if (res.length == 2) {
            res[0] = 0;
            res[1] = 1;
        } else if (res.length == 3) {
            res[0] = 0;
            res[1] = 1;
            res[2] = 1;
        }
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            int count = 0;
            int t = i;
            while (t > 0) {
                int x = t % 2;
                t = t / 2;
                if (x == 1) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
