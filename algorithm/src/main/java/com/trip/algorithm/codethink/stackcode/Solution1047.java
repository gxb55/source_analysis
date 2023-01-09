package com.trip.algorithm.codethink.stackcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2022/11/16 15:53
 * @description Solution1047
 * "abbaca"
 * 输出："ca"
 */
public class Solution1047 {
    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        String str="abbaca";
        String s = solution1047.removeDuplicates(str);
        System.out.println(s);
    }
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (Character c:chars){
            boolean flag =true;
            while (!deque.isEmpty()&& c.equals(deque.peekLast())){
                flag=false;
                deque.pollLast();
            }
            if(flag){
                deque.addLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder.append(deque.pop());
        }
        return stringBuilder.toString();
    }
}
