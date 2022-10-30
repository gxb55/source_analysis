package com.trip.algorithm.leet.some.everday;

import java.util.Stack;

/**
 * @author xbguo
 * @date 2022/8/5  19:44
 * @description 394. 字符串解码
 */
public class Solution394 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String s = "3[a]2[bc]2c";
        String res = solution394.decodeString(s);
        System.out.println(res);
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder len = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != ']') {
                stack.add(aChar);
            } else {
                stringBuilder.setLength(0);
                len.setLength(0);
                while (stack.peek() != '[') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    len.append(stack.pop());
                }
                String s1 = stringBuilder.reverse().toString();
                Integer integer = Integer.valueOf(len.reverse().toString());
                stringBuilder.setLength(0);
                for (int j = 0; j < integer; j++) {
                    stringBuilder.append(s1);
                }
                char[] chars1 = stringBuilder.toString().toCharArray();
                for (int j = 0; j < stringBuilder.length(); j++) {
                    stack.add(chars1[j]);
                }
            }
        }


        stringBuilder.setLength(0);
        len.setLength(0);
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
