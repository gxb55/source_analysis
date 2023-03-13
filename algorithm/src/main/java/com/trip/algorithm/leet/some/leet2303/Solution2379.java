package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @date 2023/3/9 17:19
 * 2379. 得到 K 个黑块的最少涂色次数
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 * 通过次数26,248提交次数42,019
 */
public class Solution2379 {
    public static void main(String[] args) {
        //  String blocks = "WBWBBBW";int k = 2;
        //  String blocks = "WBBWWBBWBW"; int k = 7;
        String blocks = "BBBBBWWBBWBWBWWWBWBWBBBBWBBBBWBWBWBWBWWBWWBWBWWWWBBWWWWBWWWWBWBBWBBWBBWWW"; int k = 29;

      //  String blocks = "BWWWBB";    int k = 6;



        int i = minimumRecolors(blocks, k);
        System.out.println(i);
    }

    public static int minimumRecolors(String blocks, int k) {

        int length = blocks.length();
        int dp[] = new int[length + 1];
        int le = length;

        for (int i = 0; i < length; i++) {
            char c = blocks.charAt(i);
            if (c == 'W') {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i];
            }

            if ((i + 1 - k) >= 0) {
                int va = dp[i + 1] - dp[i + 1 - k];
                le = Math.min(va, le);
            }
        }
        return le;
    }
}
