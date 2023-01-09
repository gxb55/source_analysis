package com.trip.algorithm.leet.some.leet08;

import java.util.Stack;

/**
 * @author xbguo
 * @date 2022/8/11  15:56
 * @description 155. 最小栈
 */
public class Solution155 {
    public static void main(String[] args) {

    }

    static class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> numStack;

        public MinStack() {
            minStack = new Stack<>();
            numStack = new Stack<>();
        }

        public void push(int val) {
            numStack.add(val);
            if (minStack.isEmpty()) {
                minStack.add(val);
            } else {
                if (val < minStack.peek()) {
                    minStack.add(val);
                } else {
                    minStack.add(minStack.peek());
                }
            }
        }

        public void pop() {
            numStack.pop();
            minStack.pop();
        }

        public int top() {
            minStack.peek();
            return numStack.peek();

        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
