package com.trip.algorithm.leet.some.leet2311;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2023/11/28 16:43
 */
public class Solution1670 {
    public static void main(String[] args) {
        FrontMiddleBackQueue queue =new FrontMiddleBackQueue();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
        System.out.println(queue.popFront());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popBack());
        System.out.println(queue.popFront());
    }
}

class FrontMiddleBackQueue {
    private LinkedList<Integer> list = new LinkedList<>();

    public FrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        int index = getIndex();
        list.add(index, val);
    }
    //1 2
    // 1 2 3
    private int getIndex() {
        int size = list.size();
        int index = size / 2;
        return index;
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if(list.isEmpty()){
            return -1;
        }
        return list.pollFirst();
    }

    public int popMiddle() {
        if(list.isEmpty()){
            return -1;
        }
        int index = getIndex();
        if(list.size()%2==0){
            index--;
        }
        return list.remove(index);
    }

    public int popBack() {
        if(list.isEmpty()){
            return -1;
        }
        return list.pollLast();
    }
}