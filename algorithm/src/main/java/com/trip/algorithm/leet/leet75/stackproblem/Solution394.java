package com.trip.algorithm.leet.leet75.stackproblem;

import java.util.LinkedList;

/**
 * @author xbguo
 * @createTime 2023年08月13日 16:44:00
 */
public class Solution394 {
    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
      //  String v = "3[a]2[bc]";
       // String v =  "2[abc]3[cd]ef";
       // String v =  "abc3[cd]xyz";
        String v = "100[leetcode]";
       // String v = "3[a2[c]]";
        String s = solution394.decodeString(v);
        System.out.println(s);
    }

    public String decodeString(String s) {
        LinkedList<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            if (val == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder count = new StringBuilder();
                while (!deque.isEmpty() && deque.peekLast() != '[') {
                    stringBuilder.append(deque.pollLast());
                }
                deque.pollLast();
                while (!deque.isEmpty() && deque.peekLast()>='0'&&deque.peekLast()<='9'){
                    count.append(deque.pollLast());
                }
                Integer integer = Integer.valueOf(count.reverse().toString());
                StringBuilder stringBuilder1 = new StringBuilder();
                String s1 = stringBuilder.reverse().toString();
                while (integer>0){
                    stringBuilder1.append(s1);
                    integer--;
                }
                char[] chars1 = stringBuilder1.toString().toCharArray();
                for (Character character:chars1){
                    deque.addLast(character);
                }
            } else {
                deque.addLast(val);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollLast());
        }
        return res.reverse().toString();
    }

}
