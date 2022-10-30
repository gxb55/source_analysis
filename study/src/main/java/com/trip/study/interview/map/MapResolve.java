package com.trip.study.interview.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xbguo
 * @createTime 2022年06月30日 08:09:00
 */
public class MapResolve {
    public static void main(String[] args) {
        //map();
        concurrentHashMap();
    }

    private static void concurrentHashMap() {
        Map<Integer,Integer> map = new ConcurrentHashMap();
        Map<Integer, Integer> map1 = Collections.synchronizedMap(map);
        map1.put(1,1);
        map1.get(1);

        /**
         * 1.线程安全
         * 2.数组 链表 红黑树
         * 3.
         */
    }

    private static void map() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map.get(1));

        /**
         * 1.构造函数
         * 2.put
         * 3.扩容
         * 4.get
         * 数组 链表 红黑树，树化
         */
        Map<Integer, Integer> map1 = Collections.synchronizedMap(map);
        map1.put(1,1);
    }
}
