package com.trip.algorithm.leet.some;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class Leet_316 {
    public static void main(String[] args) {
        Leet_316 leet_316 = new Leet_316();
        String s = leet_316.removeDuplicateLetters("acabc");
        String s1 = leet_316.getD("acabc");
        System.out.println(s);
    }

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            Character a = chars[i];
            if (stack.isEmpty()) {
                stack.add(a);
                map.put(a, map.get(a) - 1);
            } else {
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (!stack.contains(a)&&a.compareTo(peek) < 0 && map.get(peek) >= 1) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (!stack.contains(a)) {
                    stack.add(a);
                }
                map.put(a, map.get(a) - 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public String getD(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
