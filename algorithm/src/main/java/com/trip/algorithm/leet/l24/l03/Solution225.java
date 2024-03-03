package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        for (int i = 0; i < queue.size(); i++) {
        }

    }
}

class MyStack {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> integers = queue1;
        queue1 = queue2;
        queue2 = integers;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}