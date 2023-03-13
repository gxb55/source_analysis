package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @date 2023/3/6 09:34
 * 1653. 使字符串平衡的最少删除次数
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'​ 。​
 * 通过次数10,031提交次数16,990
 */
public class Solution1653 {
    public static void main(String[] args) {

    }

    public static int minimumDeletions(String s) {
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                //右边的a
                righta--;
            } else {
                //左边的b
                leftb++;
            }
            //
            res = Math.min(res, leftb + righta);
        }
        return res;

    }

    public int minimumDeletions1(String s) {
        int f = 0, cntB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                ++cntB; // f 值不变
            } else {
                f = Math.min(f + 1, cntB);
            }
        }
        return f;
    }

}
