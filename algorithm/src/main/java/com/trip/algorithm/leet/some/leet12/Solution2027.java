package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/27 09:36
 * @description 2027
 * 2027. 转换字符串的最少操作次数
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * <p>
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 * <p>
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * 示例 2：
 * <p>
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 * 示例 3：
 * <p>
 * 输入：s = "OOOO"
 * 输出：0
 * 解释：s 中不存在需要转换的 'X' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 1000
 * s[i] 为 'X' 或 'O'
 * 通过次数11,729提交次数19,047
 */
public class Solution2027 {
    public static void main(String[] args) {
        Solution2027 solution2027 = new Solution2027();
        String s="XXOX";
        int i = solution2027.minimumMoves(s);
        System.out.println(i);
    }

    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'X') {
                i = i + 2;
                res++;
            }
        }
        return res;
    }
}
