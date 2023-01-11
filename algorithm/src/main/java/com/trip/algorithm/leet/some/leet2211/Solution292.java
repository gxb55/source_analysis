package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月19日 11:37:00
 * 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合， 你作为先手 。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：false
 * 解释：以下是可能的结果:
 * 1. 移除1颗石头。你的朋友移走了3块石头，包括最后一块。你的朋友赢了。
 * 2. 移除2个石子。你的朋友移走2块石头，包括最后一块。你的朋友赢了。
 * 3.你移走3颗石子。你的朋友移走了最后一块石头。你的朋友赢了。
 * 在所有结果中，你的朋友是赢家。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：n = 2
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 通过次数147,482提交次数209,341
 */
public class Solution292 {
    public static void main(String[] args) {
        Solution292 solution292 = new Solution292();
        int x=5;
        boolean b = solution292.canWinNim(x);
        System.out.println(b);
    }

    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[][] dp = new boolean[2][n + 1];
        dp[0][1] = true;
        dp[0][2] = true;
        dp[0][3] = true;
        dp[1][1] = false;
        dp[1][2] = false;
        dp[1][3] = false;
        for (int i = 4; i <= n; i++) {
            if (dp[1][i - 1] || dp[1][i - 2] || dp[1][i - 3]) {
                dp[0][i] = true;
                dp[1][i] = false;
            } else {
                dp[0][i] = false;
                dp[1][i] = true;
            }
        }
        return dp[0][n];
    }
}
