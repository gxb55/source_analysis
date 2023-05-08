package com.trip.algorithm.countdown.dp.day0429;

/**
 * @author xbguo
 * @createTime 2023年04月29日 15:25:00
 * 650. 只有两个键的键盘
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 通过次数65,270提交次数113,228
 *
 * 恶心人的题，技巧不明显！
 */
public class Solution650 {

    public static void main(String[] args) {
        //  int n=12;
        int n = 9;
        int i = Solution650.minSteps(n);
        System.out.println(i);
    }

    public static int minSteps1(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }


    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int t = 1; t * t <= i; t++) {
                if (i % t == 0) {
                    int x = i / t;
                    int y = t;
                    dp[i] = Math.min(dp[i], dp[y] + x);
                    dp[i] = Math.min(dp[i], dp[x] + y);
                }
            }
        }
        return dp[n];
    }


}
