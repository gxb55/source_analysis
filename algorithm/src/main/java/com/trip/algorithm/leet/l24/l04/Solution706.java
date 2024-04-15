package com.trip.algorithm.leet.l24.l04;

/**
 * @author xbguo
 * @date 2024/4/15 14:23
 */
public class Solution706 {
    public static void main(String[] args) {

    }

}

class MyHashMap {
    Integer[] lists;

    public MyHashMap() {
        lists = new Integer[1000000];
    }

    public void put(int key, int value) {
        lists[key] = value;
    }

    public int get(int key) {
        Integer val = lists[key];
        if (val == null) {
            return -1;
        }
        return lists[key];
    }

    public void remove(int key) {
        lists[key] = null;
    }
}
