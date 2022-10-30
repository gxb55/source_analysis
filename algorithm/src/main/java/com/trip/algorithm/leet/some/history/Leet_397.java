package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月02日 13:35:00
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 通过次数54,358提交次数126,573
 */
public class Leet_397 {
    public static void main(String[] args) {
        Leet_397 leet_397 = new Leet_397();
        int i = leet_397.integerReplacement(2147483647);
        System.out.println(i);
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        int index = 0;
        getResult(n, index);
        return cur;
    }

    int cur = Integer.MAX_VALUE;

    private void getResult(long n, int index) {
        if (n == 1) {
            cur = Math.min(cur, index);
            return;
        }
        if (n % 2 == 1) {
            getResult(n + 1, index + 1);
            getResult(n - 1, index + 1);
        } else {
            getResult(n / 2, index + 1);
        }

    }
}