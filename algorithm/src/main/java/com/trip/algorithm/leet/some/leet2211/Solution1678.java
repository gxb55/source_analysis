package com.trip.algorithm.leet.some.leet2211;

/**
 * @author xbguo
 * @createTime 2022年11月06日 20:11:00
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command
 * 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal
 * 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class Solution1678 {
    public static void main(String[] args) {
        Solution1678 solution1678 = new Solution1678();
        String command = "G()(al)";
        command = "G()()()()(al)";
        command = "(al)G(al)()()G";
        String interpret = solution1678.interpret(command);
        System.out.println(interpret);
    }

    public String interpret(String command) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = command.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character cur = chars[i];
            //解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al"
            if (cur == 'G') {
                stringBuilder.append("G");
            } else if (cur == '(') {
                if (i + 1 < chars.length) {
                    char aChar = chars[i + 1];
                    if (aChar == ')') {
                        stringBuilder.append("o");
                        i++;
                    } else if (aChar == 'a') {
                        i += 3;
                        stringBuilder.append("al");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
