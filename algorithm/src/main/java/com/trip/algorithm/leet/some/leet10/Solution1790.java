package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/11 16:18
 * @description: 1790
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * 通过次数45,951提交次数85,059
 */
public class Solution1790 {
    public static void main(String[] args) {
        Solution1790 solution1790 = new Solution1790();
        String s1 = "bank", s2 = "kacb";
        boolean b = solution1790.areAlmostEqual(s1,s2);
        System.out.println(b);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s2.equals(s1)) {
            return true;
        }
        if (s2.length() != s1.length()) {
            return false;
        }
        Integer a = -1;
        Integer b = -1;
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s2.charAt(i) != s1.charAt(i)) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                    if (s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a)) {
                        flag = true;
                    }
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
