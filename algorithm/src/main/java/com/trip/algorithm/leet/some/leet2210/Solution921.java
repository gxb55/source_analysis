package com.trip.algorithm.leet.some.leet2210;

import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年10月07日 16:22:00
 */
public class Solution921 {
    public static void main(String[] args) {
        Solution921 solution921 = new Solution921();
       // String s="())";
        String s="(((";
        int i = solution921.minAddToMakeValid(s);
        System.out.println(i);
    }
    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar=='('){
                stack.add(aChar);
            }else{
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.add(aChar);
                }
            }
        }
        return stack.size();
    }
}
