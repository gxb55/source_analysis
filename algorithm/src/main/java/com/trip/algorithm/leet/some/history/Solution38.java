package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/1/14  10:59
 * @description 外观数列
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 例如，数字字符串 "3322251" 的描述如下图：
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 30
 * 通过次数256,899提交次数430,014
 */
public class Solution38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        String s = solution38.countAndSay(9);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return getResult(n, "1");
    }

    /**
     * @param n     第几个数字
     * @param first 当前数字是什么样子
     * @return
     */
    private String getResult(int n, String first) {
        if (n == 1) {
            return first ;
        }
        return getResult(n - 1, calculation(first));
    }

    private String calculation(String first) {
        StringBuilder sb = new StringBuilder();
        char[] chars = first.toCharArray();
        int num = 0;
        char last = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == last) {
                num++;
            } else {
                sb.append(num).append(last);
                num=1;
            }
            last=chars[i];
        }
        sb.append(num).append(last);
        return sb.toString();
    }

}
