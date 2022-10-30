package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年05月31日 10:13:00
 * 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * 通过次数136,908提交次数277,864
 */
public class Solution844 {
    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
      //  String s = "a#c", t = "b";
        String s = "ab##", t = "c#d#";
        boolean b = solution844.backspaceCompare(s, t);
        System.out.println(b);
    }

    public boolean backspaceCompare(String s, String t) {
        s = getStr(s);
        t = getStr(t);
        return s.equals(t);
    }

    private String getStr(String s) {
        if (s.indexOf("#") == -1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : s.toCharArray()) {
            if (character == '#' && stringBuilder.length() > 0) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            if(character != '#'){
                stringBuilder.append(character);
            }

        }
        return stringBuilder.toString();
    }
}
