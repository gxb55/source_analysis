package com.trip.algorithm.codethink.stackcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/11/15 19:24
 * @description Solution225
 */
public class Solution225 {
    public static void main(String[] args) {

    }
}
class MyStack {
    List<Integer> list;
    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        return list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}