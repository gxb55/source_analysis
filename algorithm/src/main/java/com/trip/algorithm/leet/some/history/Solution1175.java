package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年06月30日 09:49:00
 * 1175. 质数排列
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：682289015
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * 通过次数13,972提交次数25,972
 */
public class Solution1175 {
    public static void main(String[] args) {
        Solution1175 solution1175 = new Solution1175();
        //int num = 5;
        int num = 100;
        int i = solution1175.numPrimeArrangements(num);
        System.out.println(i);
    }

    public int numPrimeArrangements(int n) {
        // 质数
        int x = 0;
        // 非质数
        int y = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) {
                x++;
            } else {
                y++;
            }
        }
        long res = 1;
        while (x > 1) {
            res = res * x;
            res=res%(1000000000 + 7);
            x--;
        }
        while (y > 1) {
            res = res * y;
            res=res%(1000000000 + 7);
            y--;
        }
        return (int) (res%(1000000000 + 7));
    }

    private boolean isPrimeNumber(int i) {
        if (i == 1) {
            return false;
        }
        int x = i / 2;
        int val;
        while (x > 1) {
            val = i % x;
            if (val == 0) {
                return false;
            }
            x--;
        }
        return true;
    }
}
