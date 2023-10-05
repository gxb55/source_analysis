package com.trip.algorithm.leet.some.leet2309;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年09月24日 11:02:00
 */
public class Solution146 {
    public static void main(String[] args) {
        /**
         * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         */
       /* LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(4));
        cache.put(4, 3);
        System.out.println(cache.get(4));*/


        PriorityQueue<int[]> queue =new PriorityQueue<>((x,y)->x[1]-y[1]);

        int[] arr2={3,3};
        int[] arr1={2,2};
        int[] arr={1,1};
        queue.add(arr1);
        queue.add(arr);
        queue.add(arr2);
        arr[1]=4;
        System.out.println(Arrays.toString(queue.poll()));
        System.out.println(Arrays.toString(queue.poll()));
        System.out.println(Arrays.toString(queue.poll()));
    }
}

class LRUCache {
    int max;
    List<Integer> list;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        max = capacity;
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     */
    public int get(int key) {
        Integer integer = map.get(key);
        if (integer == null) {
            return -1;
        }
        list.remove(Integer.valueOf(key));
        list.add(key);
        return integer;
    }

    /**
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
     * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        int i = get(key);
        if (i == -1) {
            if (map.size() >= max) {
                Integer remove = list.remove(0);
                map.remove(remove);
                list.add(key);
                map.put(key, value);
            } else {
                list.add(key);
                map.put(key, value);
            }
            return;
        }
        if (i != value) {
            list.remove(Integer.valueOf(key));
            list.add(key);
            map.put(key, value);
        }
    }
}