package com.trip.algorithm.leet.l24.l100;

import java.util.LinkedList;

public class Solution394 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
         s = "100[leetcode]";
        String string = decodeString(s);
        System.out.println(string);
    }

    public static String decodeString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder count = new StringBuilder();
        LinkedList<Character> list=new LinkedList<>();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c !=']') {
                list.addLast(c);
            }
            if (c == ']') {
               while (list.peekLast()!='['){
                   res.append(list.pollLast());
               }
                list.pollLast();
               while (!list.isEmpty()&&list.peekLast()>='0'&&list.peekLast()<='9'){
                   count.append(list.pollLast());
               }
               int a=Integer.parseInt(count.reverse().toString());
               String string = res.reverse().toString();
                for (int j = 0; j < a; j++) {
                    for (int k = 0; k < string.length(); k++) {
                        list.add(string.charAt(k));
                    }
                }
                res.setLength(0);
                count.setLength(0);
            }
        }
        while (!list.isEmpty()){
            res.append(list.pollFirst());
        }
        return res.toString();
    }
}
