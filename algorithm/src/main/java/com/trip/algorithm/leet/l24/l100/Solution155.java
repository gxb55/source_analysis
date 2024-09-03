package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayDeque;

public class Solution155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();
    private ArrayDeque<Integer> min = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {
        deque.addLast(val);
        if (min.isEmpty()) {
            min.addLast(val);
        } else {
            Integer v = min.peekLast();
            if (v < val) {
                min.addLast(v);
            } else {
                min.addLast(val);
            }
        }
    }

    public void pop() {
        min.pollLast();
        deque.pollLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public int getMin() {
        return min.peekLast();
    }
}