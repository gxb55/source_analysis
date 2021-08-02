package com.trip.study.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K,V> extends LinkedHashMap<K, V> {
    private int capacity;

    /**
     * accessOrder – the ordering mode -
     * true for access-order,
     * false for insertion-order
     * @param capacity
     */
    public LRUCacheDemo( int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return super.size()>capacity;
    }
    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1,"A");
        lruCacheDemo.put(2,"A");
        lruCacheDemo.put(3,"A");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4,"A");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"A");
        lruCacheDemo.put(3,"A");
        lruCacheDemo.put(3,"A");
        lruCacheDemo.put(3,"A");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"A");
        System.out.println(lruCacheDemo.keySet());
    }
}
