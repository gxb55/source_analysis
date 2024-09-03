package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution20 {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (Character c:charArray){
            if(c==')'){
                if(deque.isEmpty()){
                    return false;
                }
                Character o = deque.pollLast();
                if(o!='('){
                    return false;
                }
            } else  if(c==']'){
                if(deque.isEmpty()){
                    return false;
                }
                Character o = deque.pollLast();
                if(o!='['){
                    return false;
                }
            } else  if(c=='}'){
                if(deque.isEmpty()){
                    return false;
                }
                Character o = deque.pollLast();
                if(o!='{'){
                    return false;
                }
            }else {
                deque.addLast(c);
            }
        }
        return deque.isEmpty();
    }
}
