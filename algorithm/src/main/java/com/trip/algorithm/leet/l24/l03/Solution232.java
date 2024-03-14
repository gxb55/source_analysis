package com.trip.algorithm.leet.l24.l03;

import java.util.Stack;

public class Solution232 {
    public static void main(String[] args) {

    }
}

class MyQueue {
    private Stack<Integer> writeStack = new Stack<>();
    private Stack<Integer> readStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        writeStack.push(x);
    }

    public int pop() {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.add(writeStack.pop());
            }
        }
        return readStack.pop();
    }

    public int peek() {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.add(writeStack.pop());
            }
        }
        return readStack.peek();
    }

    public boolean empty() {
        return readStack.isEmpty() && writeStack.isEmpty();
    }
}