package com.trip.algorithm.leet.some.leet10;

import java.util.Stack;

/**
 * @auther: xbguo
 * @date: 2022/10/9 15:51
 * @description: 856
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 */
public class Solution856 {
    public static void main(String[] args) {
        Solution856 solution856 = new Solution856();
        String s = "()";
        s = "(())";
        s = "()()";
        s = "(()(()))";
        int i = solution856.scoreOfParentheses(s);
        System.out.println(i);
    }

    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (Character character : chars) {
            String val = character.toString();
            if (val.equals("(")) {
                stack.add(val);
            } else if (val.equals(")")) {
                int cur = 0;
                while (!stack.peek().equals("(")) {
                    cur = cur + Integer.valueOf(stack.pop());
                }
                stack.pop();
                if (cur == 0) {
                    stack.add("1");
                } else {
                    stack.add(2 * cur + "");
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += Integer.valueOf(stack.pop());
        }
        return ans;
    }
}
