package com.trip.algorithm.codethink.stackcode;

import java.util.Stack;

/**
 * @author xbguo
 * @date 2022/11/15 19:28
 * @description Solution20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution20 {
    public static void main(String[] args) {
//"([)]"
        String str="([)]";
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid(str);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> deque = new Stack<>();
        for (Character character : chars) {
            if (character == ')') {
                if (!deque.isEmpty() &&deque.peek() == '(') {
                    deque.pop();
                } else {
                    return false;
                }
            } else if (character == ']') {
                if (!deque.isEmpty() &&deque.peek() == '[') {
                    deque.pop();
                } else {
                    return false;
                }
            } else if (character == '}') {
                if (!deque.isEmpty() &&deque.peek() == '{') {
                    deque.pop();
                } else {
                    return false;
                }
            } else {
                deque.add(character);
            }
        }
        return deque.isEmpty();
    }
}
