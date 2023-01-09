package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/5/13  21:29
 * @description 面试题 01.05. 一次编辑
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 通过次数68,236提交次数194,259
 */
public class Solution01_05 {
    public static void main(String[] args) {
        Solution01_05 solution01_05 = new Solution01_05();
        /*String first = "pal0";
        String second = "pale";*/
        String first = "";
        String second = "a";
        boolean b = solution01_05.oneEditAway(first, second);
        System.out.println(b);
    }

    public boolean oneEditAway(String first, String second) {
        if (second.length() > first.length()) {
            String temp = first;
            first = second;
            second = temp;

        }
        if (first.equals(second)) {
            return true;
        } else if (first.length() > second.length() && first.length() == second.length() + 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < second.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    String s = stringBuilder.append(first, 0, i).append(first, i + 1, first.length()).toString();
                    return s.equals(second);
                }
            }
            String s = stringBuilder.append(first, 0, first.length() - 1).toString();
            return s.equals(second);
        } else if (first.length() == second.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < second.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    String s = stringBuilder.append(first, 0, i).append(second.charAt(i)).append(first, i + 1, first.length()).toString();
                    return s.equals(second);
                }
            }
        }
        return false;

    }
}
