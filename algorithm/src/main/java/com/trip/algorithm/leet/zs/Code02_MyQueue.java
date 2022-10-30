package com.trip.algorithm.leet.zs;

import java.util.Stack;

/**
 * @author xbguo
 * @createTime 2022年07月02日 11:15:00
 */
public class Code02_MyQueue<T> {
    private Stack<T> pushStack;
    private Stack<T> pullStack;

    public Code02_MyQueue() {
        pushStack = new Stack<>();
        pullStack = new Stack<>();
    }

    public void add(T t) {
        pushStack.add(t);
    }

    public T peek() {
        fill();
        return pullStack.peek();
    }
    public T pop() {
        fill();
        return pullStack.pop();
    }

    private void fill() {
        if (!isEmpty()) {
            if (pullStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    pullStack.add(pushStack.pop());
                }
            }
        }

    }

    private boolean isEmpty() {
        return pullStack.isEmpty() && pushStack.isEmpty();
    }

    public static void main(String[] args) {
        Code02_MyQueue<Integer> queue = new Code02_MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }
}
