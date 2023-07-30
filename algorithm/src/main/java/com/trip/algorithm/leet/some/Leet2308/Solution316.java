package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @createTime 2023年07月30日 20:53:00
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 */
public class Solution316 {
    public static void main(String[] args) {
       // String q="bcabc";
       // String q="cbacdcbc";
        String q="abacb";
        String s = removeDuplicateLetters(q);
        System.out.println(s);

        Deque<Character> queue = new ArrayDeque<>();
        queue.add('a');
        queue.add('b');
        queue.add('c');
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();
        int[] last = new int[26];
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            last[aChar - 'a'] = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (queue.contains(curChar)) {
                continue;
            }
            while (!queue.isEmpty() && curChar < queue.peekLast() && last[queue.peekLast() - 'a'] > i) {
                queue.pollLast();
            }
            queue.addLast(curChar);
        }
        for (Character character:queue){
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
