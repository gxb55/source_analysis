package com.trip.algorithm.leet.zs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xbguo
 * @createTime 2022年07月02日 10:51:00
 * 用队列实现栈
 */
public class Code02_MyStack<T> {
    private Queue<T> pushQueue;
    private Queue<T> pullQueue;

    public Code02_MyStack() {
        this.pushQueue = new LinkedList<>();
        this.pullQueue = new LinkedList<>();
    }

    public void add(T t) {
        if (!pullQueue.isEmpty()) {
            pullQueue.add(t);
        } else {
            pushQueue.add(t);
        }

    }

    public T peek() {
        if (pushQueue.isEmpty()) {
            while (pullQueue.size() > 1) {
                pushQueue.add(pullQueue.poll());
            }
            T res = pullQueue.peek();
            pushQueue.add(pullQueue.poll());
            return res;
        } else {
            while (pushQueue.size() > 1) {
                pullQueue.add(pushQueue.poll());
            }
            T res = pushQueue.peek();
            pullQueue.add(pushQueue.poll());
            return res;
        }
    }

    public T poll() {
        if (pushQueue.isEmpty()) {
            while (pullQueue.size() > 1) {
                pushQueue.add(pullQueue.poll());
            }
            return pullQueue.poll();
        } else {
            while (pushQueue.size() > 1) {
                pullQueue.add(pushQueue.poll());
            }
            return pushQueue.poll();
        }
    }

    public static void main(String[] args) {
        Code02_MyStack<Integer> myStack = new Code02_MyStack<>();
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.add(4);
        System.out.println(myStack.poll());
        myStack.add(5);
        myStack.add(6);
        myStack.add(7);
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());

    }
}
