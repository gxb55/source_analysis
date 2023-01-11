package com.trip.algorithm.codethink.stackcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xbguo
 * @date 2022/11/15 19:20
 * @description Solution232
 */
public class Solution232 {
}

class MyQueue {
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public MyQueue() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int x) {
        deque1.add(x);
    }

    public int pop() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.add(deque1.pop());
            }
        }
        return deque2.pop();
    }

    public int peek() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.add(deque1.pop());
            }
        }
        return deque2.peek();
    }

    public boolean empty() {
        return deque2.isEmpty() && deque1.isEmpty();
    }
}